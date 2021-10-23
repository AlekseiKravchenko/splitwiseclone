package SplitwiseClone.repository;

import SplitwiseClone.entity.User;
import SplitwiseClone.utils.IdGenerator;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
public class UserRepository implements CrudRepository<User> {
    private static final Map<Long, User> userMap = new HashMap<>();

    @Override
    public void add(User object) {
        object.setId(IdGenerator.generateDebtId());
        userMap.put(object.getId(), object);
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
