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
import javax.servlet.http.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {

    private Connection connection;
    private CustomerService customerService;
    private CustomerDAO customerDAO;
    private TestDAO testDAO;
    private TestService testService;
    private static final int ITEMS_PER_PAGE = 6;

    @Override
    public void init() throws ServletException {
        this.customerDAO = new CustomerService(connection);

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
        this.testDAO = new TestService(connection);
//
//        Integer page = Integer.valueOf(req.getParameter("page"));
//        if (page < 0)
//            page = 0;
//        int page = 1;
//        long totalCount = testDAO.count();
//        if(req.getParameter("page") != null)
//            page = Integer.parseInt(req
//                    .getParameter("page"));
//
//
//        long pageCount = (totalCount / ITEMS_PER_PAGE) +
//                ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
        List<Test> tests;
        int currentPage = 1;
        int recordsOnPage = 6;

        if (req.getParameter("page") != null) {
            currentPage = Integer.parseInt(req.getParameter("page"));
        }

        tests = testDAO.getAllTestsPaging((currentPage-1) * recordsOnPage,
                recordsOnPage);

        System.out.println(tests);

        int periodicalsCount = testDAO.count();
        int numberOfPages = (int) Math.ceil(periodicalsCount * 1.0 / recordsOnPage);


//        List<Test> tests = testDAO.findAll();

        if(req.getParameter("subject") !=null && req.getParameter("subject") !=""){
            String subject = req.getParameter("subject");
            tests = testDAO.findAllBySubject(subject);
        } else {
//            tests = testDAO.findAll();
        }
        req.setAttribute("AllTests", tests);

        ///

        req.setAttribute("numberOfPages", numberOfPages);
        req.setAttribute("currentPage", currentPage);
        req.setAttribute("periodicalsCount", periodicalsCount);

//        req.setAttribute("pages", pageCount);


//        HttpSession session = req.getSession();
//        Customer customer = (Customer) session.getAttribute("user");
//        String login = customer.getLogin();
//        UserRole role = customer.getRole();

////        Optional<Customer> customerOne = customerDAO.findByLogin(login);
//        req.setAttribute("login", login);
//        req.setAttribute("role", role);

//        req.setAttribute("itemPerPage", ITEMS_PER_PAGE);


//        int currentPage = 1;
//        int recordsOnPage = 5;
//
//        if (req.getParameter("page") != null) {
//            currentPage = Integer.parseInt(req.getParameter("page"));
//        }

        req.getServletContext().getRequestDispatcher("/jsp/home.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.customerDAO = new CustomerService(connection);


//        Integer id = Integer.parseInt(req.getParameter("id"));
//        String email = req.getParameter("email");
//        String phone = req.getParameter("phone");
//        String address = req.getParameter("address");
//
//        Customer customer = new Customer(id, email, phone, address);
//        customerDAO.update(customer);


        //        String color = req.getParameter("color");
//        Cookie colorCookie = new Cookie("color", color);
//        resp.addCookie(colorCookie);


//        String email = req.getParameter("email");
//        String phone = req.getParameter("phone");
//        String address = req.getParameter("address");
//        int id = Integer.parseInt(req.getParameter("id"));
//
//        Customer customer = new Customer(id, email, phone, address);
//        this.customerDAO = new CustomerService(connection);
//        customerDAO.update(customer);
        String login = req.getParameter("login");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");

        Customer customer = new Customer(login, email, phone, address);
        customerDAO.update(customer);
        
        resp.sendRedirect(req.getContextPath() + "/home");
    }
}
