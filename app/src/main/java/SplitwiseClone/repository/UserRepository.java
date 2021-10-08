package SplitwiseClone.repository;

import SplitwiseClone.entity.User;
import lombok.NoArgsConstructor;

import java.util.*;

@NoArgsConstructor
public class UserRepository implements CrudRepository<User> {
    private static final Map<Long, User> userMap = new HashMap<>();

    @Override
    public void add(Long id, User object) {
        userMap.put(id,object);
    }

    @Override
    public void delete(Long id) {
        userMap.remove(id);
    }

    @Override
    public User getById(Long id) {
        return userMap.get(id);
    }
    @Override
    public List<User> getAll() {
        return new ArrayList<>(userMap.values());
    }

    @Override
    public boolean contains(Long id) {
        return userMap.containsKey(id);
    }

    @Override
    public void deleteAll() {
        userMap.clear();
    }
}
