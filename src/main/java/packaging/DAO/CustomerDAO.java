package packaging.DAO;

import packaging.entity.Customer;

import java.util.Optional;

public interface CustomerDAO extends CrudDAO<Customer>{
    Optional<Customer> findByLogin(String login);
    boolean isExist(String login, String password);
}
