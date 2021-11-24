package packaging.servlets;


import packaging.DAO.CustomerDAO;
import packaging.DAO.TestDAO;
import packaging.service.CustomerService;
import packaging.service.TestService;

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
import java.util.Properties;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {

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
//        this.customerDAO = new CustomerService(connection);
//
//        Integer id = Integer.valueOf(req.getParameter("delete_user"));
//        if (id != null && !id.equals("")) {
//            customerDAO.delete(id);
//            resp.sendRedirect(req.getContextPath() + "/jsp/admin.jsp");
//        }
        req.getServletContext().getRequestDispatcher("/jsp/admin.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.customerDAO = new CustomerService(connection);
//        this.testDAO = new TestService(connection);
//
//        String subject = req.getParameter("subject");
//        String question1 = req.getParameter("question1");
//        String question2 = req.getParameter("question2");
//        String question3 = req.getParameter("question3");
//        String time = req.getParameter("time");
//        Degree degree = Degree.valueOf(req.getParameter("degree"));
//
//        Test test = new Test(subject, question1, question2, question3, time, degree);
//        testDAO.save(test);

//        String delete = req.getParameter("toDelete[]");
//        Integer id = Integer.valueOf(req.getParameter("delete_user"));
        Integer list = Integer.valueOf(req.getParameter("delete_user"));
//        String dd = req.getParameter("delete_user");
        if (list != null && !list.equals("")) {
            customerDAO.delete(list);
            resp.sendRedirect(req.getContextPath() + "/jsp/admin.jsp");
        }


//        String login = req.getParameter("login");
//
//        if (login != null && !login.equals("")) {
//            customerDAO.deleteCustomerByLogin(login);
//            resp.sendRedirect(req.getContextPath() + "/jsp/admin.jsp");
//        }

        resp.sendRedirect(req.getContextPath() + "/jsp/admin.jsp");
//        doGet(req, resp);
    }
}