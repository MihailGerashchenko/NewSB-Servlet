package packaging.DAO;

import packaging.entity.Customer;

import java.util.List;

public interface CrudDAO<T> {
    Customer find (Integer id);
    boolean save (T model);
    boolean update (T model);
    boolean delete (Integer id);
    Integer count();

    List<T> findAll();
}
