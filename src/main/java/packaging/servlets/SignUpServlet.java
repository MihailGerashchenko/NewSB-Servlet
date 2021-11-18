package packaging.servlets;

import packaging.DAO.CustomerDAO;
import packaging.entity.Customer;
import packaging.entity.UserRole;
import packaging.service.CustomerService;

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

@WebServlet("/signUp")
public class SignUpServlet extends HttpServlet {

    //    private UsersRepository usersRepository;
    private Connection connection;
    private CustomerService customerService;
    private CustomerDAO customerDAO;


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
//        List<User> users = usersRepository.findAll();
//        req.setAttribute("usersFromServer", users);
        this.customerDAO = new CustomerService(connection);
        List<Customer> customers = customerDAO.findAll();
        req.setAttribute("allUsers", customers);
        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/jsp/signUp.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.customerDAO = new CustomerService(connection);

        String name = req.getParameter("login");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");

        Customer customer = new Customer(name, password, UserRole.STUDENT, email, phone, address);
        customerDAO.save(customer);

//        try {
//            PreparedStatement ps = connection.prepareStatement("INSERT INTO customersone (login, password, role, email, phone, address) VALUES (?, ?, ?, ?, ?, ?)");
//            ps.setString(1, name);
//            ps.setString(2, password);
//            ps.setString(3, UserRole.STUDENT.toString());
//            ps.setString(4, email);
//            ps.setString(5, phone);
//            ps.setString(6, address);
//
////            String sqlInsert = "INSERT INTO customer (id, login, password, email, phone, address) VALUES ('" + name + "','" + password + "');";
////            statement.execute(sqlInsert);
//            ps.execute();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }


        doGet(req, resp);
    }
}
