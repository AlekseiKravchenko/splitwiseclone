package SplitwiseClone.repository;

import java.util.List;

public interface CrudRepository<T> {
     void add(Long id, T object);
     void delete(Long id);
     T getById(Long id);
     boolean contains(Long id);
     void deleteAll();
     List<T> getAll();
}
