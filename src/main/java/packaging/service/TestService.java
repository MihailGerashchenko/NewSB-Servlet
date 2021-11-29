package packaging.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import packaging.DAO.TestDAO;
import packaging.entity.Customer;
import packaging.entity.Degree;
import packaging.entity.Test;
import packaging.mapper.TestMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TestService implements TestDAO {

    private static final Logger logger = LogManager.getLogger();

    private final String SQL_SELECT_ALL = "SELECT * FROM testsone";
    private final String SQL_SELECT_ALL_BY_SUBJECT = "SELECT * FROM testsone WHERE subject = ?";
    private final String SQL_INSERT_INTO = "INSERT INTO testsone (subject, question1, question2, question3, time, degree, customer_id) VALUES (?, ?, ?, ?, ?, ?, ?)";

    private Connection connection;

    public TestService(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Customer find(Integer id) {
        return null;
    }

    @Override
    public boolean save(Test model) {
        try {
            PreparedStatement ps = connection.prepareStatement(SQL_INSERT_INTO);
            ps.setString(1, model.getSubject());
            ps.setString(2, model.getQuestion1());
            ps.setString(3, model.getQuestion2());
            ps.setString(4, model.getQuestion3());
            ps.setString(5, model.getTime());
            ps.setString(6, String.valueOf(model.getDegree()));
            ps.setString(7, String.valueOf(model.getCustomer()));

            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            logger.error("Test with subject " + model.getSubject() + " was not saved into database", e);
        }
        return false;
    }

    @Override
    public boolean update(Test model) {
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public Integer count() {
        try {
            Integer num = 0;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL);
            while (resultSet.next()) {
                num++;
            }
            return num;
        } catch (SQLException e) {
            logger.error("The count of tests was not calculated", e);
        }
        return null;
    }

    @Override
    public List<Test> findAll() {
        try {
            List<Test> tests = new ArrayList<>();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL);
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String subject = resultSet.getString("subject");
                String question1 = resultSet.getString("question1");
                String question2 = resultSet.getString("question2");
                String question3 = resultSet.getString("question3");
                String time = resultSet.getString("time");
                Degree degree = Degree.valueOf(resultSet.getString("degree"));

                Test test = new Test(id, subject, question1, question2, question3, time, degree);
                tests.add(test);
            }
            return tests;
        } catch (SQLException e) {
            logger.error("All tests were not found in the database", e);
        }
        return null;
    }

    @Override
    public List<Test> findAllBySubject(String subject) {
        try {
            List<Test> tests = new ArrayList<>();
            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_ALL_BY_SUBJECT);
            statement.setString(1, subject);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String sub = resultSet.getString("subject");
                String question1 = resultSet.getString("question1");
                String question2 = resultSet.getString("question2");
                String question3 = resultSet.getString("question3");
                String time = resultSet.getString("time");
                Degree degree = Degree.valueOf(resultSet.getString("degree"));

                if (sub.equals(subject)) {
                    Test test = new Test(id, sub, question1, question2, question3, time, degree);
                    tests.add(test);
                }
            }
            return tests;
        } catch (SQLException e) {
            logger.error("The test with subject " + subject + " was not found in the database", e);
        }
        return null;
    }

    @Override
    public List<Test> getAllTestsPaging(int offset, int recordsOnPage) {
        List<Test> list = new ArrayList<>();
        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append(SQL_SELECT_ALL);
        queryBuilder.append(" ORDER BY ").append("subject ASC, degree DESC");
        queryBuilder.append(" LIMIT ").append(recordsOnPage).append(" ").append("OFFSET ").append(offset);
        try (PreparedStatement ps = connection.prepareCall(queryBuilder.toString());
             ResultSet rs = ps.executeQuery();) {
            TestMapper mapper = new TestMapper();
            while (rs.next()) {
                list.add(mapper.extractFromResultSet(rs));
            }
            return list;
        } catch (SQLException e) {
            logger.error("All tests paging were not found in the database", e);
            return null;
        }
    }
}
