package packaging.servlets;

import packaging.DAO.CustomerDAO;
import packaging.DAO.TestDAO;
import packaging.entity.Customer;
import packaging.entity.Test;
import packaging.service.CustomerService;
import packaging.service.TestService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        List<Test> tests = testDAO.findAll();



        if(req.getParameter("subject") !=null && req.getParameter("subject") !=""){
            String subject = req.getParameter("subject");
            tests = testDAO.findAllBySubject(subject);
        } else {
            tests = testDAO.findAll();
        }
        req.setAttribute("AllTests", tests);
//        Integer id = Integer.parseInt(req.getParameter("id"));
//        Optional<Customer> customer = customerDAO.find(id);
//        req.setAttribute("customer", customer);
        req.getServletContext().getRequestDispatcher("/jsp/home.jsp").forward(req, resp);
//        Integer id = Integer.parseInt(req.getParameter("id"));
//        Optional<Customer> customer = customerDAO.find(id);
//        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/jsp/home.jsp");
//        req.setAttribute("customer", customer);
//        dispatcher.forward(req, resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
        resp.sendRedirect(req.getContextPath() + "/home");
    }
}
