package packaging.DAO;

import java.util.List;
import java.util.Optional;

public interface CrudDAO<T> {
    Optional<T> find (Integer id);
    boolean save (T model);
    boolean update (T model);
    boolean delete (Integer id);

    List<T> findAll();
}
