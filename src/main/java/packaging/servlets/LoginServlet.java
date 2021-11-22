package packaging.servlets;

import packaging.DAO.CustomerDAO;
import packaging.entity.Customer;
import packaging.entity.UserRole;
import packaging.service.BCryptService;
import packaging.service.CustomerService;

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
import java.util.function.Function;
import java.util.stream.Collectors;

@WebServlet("/")
public class LoginServlet extends HttpServlet {

    private Connection connection;
    private CustomerService customerService;
    private CustomerDAO customerDAO;
    private static final BCryptService bcrypt = new BCryptService(10);
    private String[] mutableHash = new String[1];
    Function<String, Boolean> update = hash -> {
        mutableHash[0] = hash;
        return true;
    };

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

        String lang = req.getParameter("lang");
        if (lang != null) {
            req.getSession().setAttribute("lang", lang);
            req.setAttribute("lang", lang);
        }
        req.getServletContext().getRequestDispatcher("/jsp/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.customerDAO = new CustomerService(connection);
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        String lang = req.getParameter("lang");
        if (lang != null) {
            req.getSession().setAttribute("lang", lang);
            req.setAttribute("lang", lang);
        }

        Optional<Customer> customer = customerDAO.findByLogin(login);

        if (customer.isPresent() && bcrypt.verifyAndUpdateHash(password, customer.get().getPassword(), update)) {
            HttpSession session = req.getSession();
            session.setAttribute("user", login);
            session.getAttribute("user");


            if (customer.get().getRole() == UserRole.ADMIN) {
                req
                        .getServletContext()
                        .getRequestDispatcher("/homeAdmin")
                        .forward(req, resp);
            } else {
                req
                        .getServletContext()
                        .getRequestDispatcher("/home")
                        .forward(req, resp);
            }
        } else {
            resp.sendRedirect(req.getContextPath() + "/");
        }
    }
}
