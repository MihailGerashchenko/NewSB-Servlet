package packaging.mapper;

import packaging.entity.Customer;
import packaging.entity.UserRole;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class CustomerMapper implements ObjectMapper<Customer> {

    @Override
    public Customer extractFromResultSet(ResultSet rs) throws SQLException {
        Customer customer = new Customer();
        customer.setId(rs.getInt("id"));
        customer.setLogin(rs.getString("login"));
        customer.setPassword(rs.getString("password"));
        customer.setRole(UserRole.valueOf(rs.getString("role")));
        customer.setEmail(rs.getString("email"));
        customer.setPhone(rs.getString("phone"));
        customer.setAddress(rs.getString("address"));
        return customer;
    }

    @Override
    public Customer makeUnique(Map<Integer, Customer> cache, Customer user) {
        cache.putIfAbsent(user.getId(), user);
        return cache.get(user.getId());
    }
}
