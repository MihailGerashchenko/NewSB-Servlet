package packaging.servlets;

import packaging.DAO.CustomerDAO;
import packaging.DAO.TestDAO;
import packaging.entity.Customer;
import packaging.entity.Test;
import packaging.entity.UserRole;
import packaging.service.CustomerService;
import packaging.service.TestService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

@WebServlet("/homeAdmin")
public class HomeAdminServlet extends HttpServlet {

    private Connection connection;
    private CustomerService customerService;
    private CustomerDAO customerDAO;
    private TestDAO testDAO;
    private TestService testService;
    private static final int ITEMS_PER_PAGE = 5;

    @Override
    public void init() throws ServletException {
        this.customerDAO = new CustomerService(connection);
        this.testDAO = new TestService(connection);

        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(getServletContext().getRealPath("/WEB-INF/classes/db.properties")));
            String dbUrl = properties.getProperty("db.url");
            String dbUsenName = properties.getProperty("db.username");
            String dbPassword = properties.getProperty("db.password");
            String driverClassName = properties.getProperty("db.driverClassName");

            Class.forName(driverClassName);
            connection = DriverManager.getConnection(dbUrl, dbUsenName, dbPassword);

        } catch (IOException | SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.customerDAO = new CustomerService(connection);
        this.testDAO = new TestService(connection);

        HttpSession session = req.getSession();

        String login = (String) session.getAttribute("user");
        Optional<Customer> customer = customerDAO.findByLogin(login);
        String address = customer.get().getAddress();
        String email = customer.get().getEmail();
        String phone = customer.get().getPhone();
        UserRole role = customer.get().getRole();

        req.setAttribute("role", role);
        req.setAttribute("login", login);
        req.setAttribute("email", email);
        req.setAttribute("phone", phone);
        req.setAttribute("address", address);

        List<Test> tests;
        int currentPage = 1;
        int recordsOnPage = 6;

        if (req.getParameter("page") != null) {
            currentPage = Integer.parseInt(req.getParameter("page"));
        }

        tests = testDAO.getAllTestsPaging((currentPage - 1) * recordsOnPage,
                recordsOnPage);

        int periodicalsCount = testDAO.count();
        int numberOfPages = (int) Math.ceil(periodicalsCount * 1.0 / recordsOnPage);


//        List<Test> tests = testDAO.findAll();

        if (req.getParameter("subject") != null && req.getParameter("subject") != "") {
            String subject = req.getParameter("subject");
            tests = testDAO.findAllBySubject(subject);
        } else {
//            tests = testDAO.findAll();
        }
        req.setAttribute("AllTests", tests);
        req.setAttribute("numberOfPages", numberOfPages);
        req.getServletContext().getRequestDispatcher("/jsp/homeAdmin.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.customerDAO = new CustomerService(connection);
        this.testDAO = new TestService(connection);

        HttpSession session = req.getSession();
        String login = (String) session.getAttribute("user");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");

        if (email == null || phone == null || address == null) {
            Optional<Customer> customer = customerDAO.findByLogin(login);
            String address1 = customer.get().getAddress();
            String email1 = customer.get().getEmail();
            String phone1 = customer.get().getPhone();
            UserRole role = customer.get().getRole();
            String password = customer.get().getPassword();
            Integer id = customer.get().getId();
            Customer customer1 = new Customer(id, login, password, role, email1, phone1, address1);
            customerDAO.update(customer1);
        } else {
            Optional<Customer> customer = customerDAO.findByLogin(login);
            UserRole role = customer.get().getRole();
            String password = customer.get().getPassword();
            Integer id = customer.get().getId();
            Customer customer1 = new Customer(id, login, password, role, email, phone, address);
            customerDAO.update(customer1);
        }

        resp.sendRedirect(req.getContextPath() + "/homeAdmin");
    }
}

