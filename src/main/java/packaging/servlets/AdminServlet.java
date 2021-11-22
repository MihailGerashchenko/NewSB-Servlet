package packaging.servlets;

import packaging.DAO.CustomerDAO;
import packaging.DAO.TestDAO;
import packaging.entity.Customer;
import packaging.entity.Degree;
import packaging.entity.Test;
import packaging.service.CustomerService;
import packaging.service.TestService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;


@WebServlet("/admin")
public class AdminServlet extends HttpServlet {

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

        List<Customer> customers = customerDAO.findAll();

        if(req.getParameter("login") !=null && req.getParameter("login") !=""){
            String login = req.getParameter("login");
            customers = customerDAO.findAllByLogin(login);
        } else {
            customers = customerDAO.findAll();
        }
        req.setAttribute("AllCustomers", customers);

//
        String action = req.getServletPath();

        try {
            switch (action) {
                case "/delete":
                    deleteUser(req, resp);
                    break;
//                case "/update":
//                    updateUser(req, resp);
//                    break;

            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
//
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/admin.jsp");
        dispatcher.forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.customerDAO = new CustomerService(connection);
        this.testDAO = new TestService(connection);

        String subject = req.getParameter("subject");
        String question1 = req.getParameter("question1");
        String question2 = req.getParameter("question2");
        String question3 = req.getParameter("question3");
        String time = req.getParameter("time");
        Degree degree = Degree.valueOf(req.getParameter("degree"));

        Test test = new Test(subject, question1, question2, question3, time, degree);
        testDAO.save(test);


        doGet(req, resp);
    }


//
//    private void updateUser(HttpServletRequest request, HttpServletResponse response)
//            throws SQLException, IOException {
//        int id = Integer.parseInt(request.getParameter("id"));
//        String name = request.getParameter("name");
//        String email = request.getParameter("email");
//        String country = request.getParameter("country");
//
//        User book = new User(id, name, email, country);
//        userDAO.updateUser(book);
//        response.sendRedirect("list");
//    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        customerDAO.delete(id);
        doGet(request, response);
//        response.sendRedirect("list");

    }

    //
}
