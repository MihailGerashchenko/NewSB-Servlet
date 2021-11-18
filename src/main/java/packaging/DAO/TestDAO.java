package packaging.DAO;

import packaging.entity.Test;

import java.util.List;
import java.util.Optional;

public interface TestDAO extends CrudDAO<Test> {
    List<Test> findAllBySubject(String subject);
}
