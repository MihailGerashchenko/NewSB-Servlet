package packaging.DAO;

import packaging.entity.Customer;
import packaging.entity.Test;

import java.util.List;
import java.util.Optional;

public interface CustomerDAO extends CrudDAO<Customer> {
    List<Customer> findAllByLogin(String login);

    boolean isExist(String login, String password);

    Optional<Customer> findByLogin(String login);

    boolean deleteCustomerByLogin(String login);

    List<Customer> getAllCustomersPaging(int offset, int recordsOnPage);

}
