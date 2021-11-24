package packaging.servlets;

import packaging.DAO.CustomerDAO;
import packaging.entity.Customer;
import packaging.service.CustomerService;

import javax.servlet.RequestDispatcher;
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
import java.util.Optional;
import java.util.Properties;

@WebServlet("/updateStudent")
public class UpdateServlet extends HttpServlet {

    private Connection connection;
    private CustomerService customerService;
    private CustomerDAO customerDAO;

    @Override
    public void init() throws ServletException {
        this.customerDAO = new CustomerService(connection);

        Properties properties = new Properties();

        try {
            properties.load(new FileInputStream(getServletContext().getRealPath("/WEB-INF/classes/db.properties")));
            String dbURL = properties.getProperty("db.url");
            String dbUserName = properties.getProperty("db.username");
            String dbPassword = properties.getProperty("db.password");
            String dbDriverClassName = properties.getProperty("db.driverClassName");

            Class.forName(dbDriverClassName);
            connection = DriverManager.getConnection(dbURL, dbUserName, dbPassword);
        } catch (IOException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.customerDAO = new CustomerService(connection);

        String lang = req.getParameter("lang");
        if (lang != null) {
            req.getSession().setAttribute("lang", lang);
            req.setAttribute("lang", lang);
        }
//
//        HttpSession session = req.getSession();
//        Customer customer = (Customer) session.getAttribute("user");
//        System.out.println(customer);

//        Integer id = Integer.parseInt(req.getParameter("id"));
//        Customer customer = customerDAO.find(id);
//        customerDAO.update(customer);
//        req.setAttribute("customer", customer);
        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/jsp/home.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.customerDAO = new CustomerService(connection);


//        Integer id = Integer.parseInt(req.getParameter("id"));
        String login = req.getParameter("login");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");

        Customer customer = new Customer(login, email, phone, address);
        customerDAO.update(customer);
        resp.sendRedirect(req.getContextPath() + "/home");
    }
}
