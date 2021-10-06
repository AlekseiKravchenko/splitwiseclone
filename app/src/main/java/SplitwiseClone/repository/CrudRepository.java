package SplitwiseClone.repository;

import java.util.List;

public interface CrudRepository<T> {
     void addToRepository(Long id, T object);
     void deleteFromRepository(Long id);
     T getFromRepositoryById(Long id);
     boolean contains(Long id);
     void deleteAll();
     List<T> getAll();
}
