package packaging.mapper;

import packaging.entity.Degree;
import packaging.entity.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class TestMapper implements ObjectMapper<Test> {

    @Override
    public Test extractFromResultSet(ResultSet rs) throws SQLException {
        Test test = new Test();
        test.setId(rs.getInt("id"));
        test.setSubject(rs.getString("subject"));
        test.setQuestion1(rs.getString("question1"));
        test.setQuestion2(rs.getString("question2"));
        test.setQuestion3(rs.getString("question3"));
        test.setTime(rs.getString("time"));
        test.setDegree(Degree.valueOf(rs.getString("degree")));
        return test;

//        Integer id = resultSet.getInt("id");
//        String sub = resultSet.getString("subject");
//        String question1 = resultSet.getString("question1");
//        String question2 = resultSet.getString("question2");
//        String question3 = resultSet.getString("question3");
//        String time = resultSet.getString("time");
//        Degree degree = Degree.valueOf(resultSet.getString("degree"));
//
    }

//    @Override
//    public Test makeUnique(Map<Long, Test> cache, Test user) {
//        return null;
//    }

    @Override
    public Test makeUnique(Map<Integer, Test> cache, Test test) {
        cache.putIfAbsent(test.getId(), test);
        return cache.get(test.getId());
    }
}
