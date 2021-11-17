package packaging.DAO;

import packaging.entity.Test;

import java.util.Optional;

public interface TestDAO extends CrudDAO<Test> {
    Optional<Test> findBySubject(String subject);
}
