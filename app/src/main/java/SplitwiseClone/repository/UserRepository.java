package SplitwiseClone.repository;

import SplitwiseClone.entity.User;
import lombok.NoArgsConstructor;

import java.util.*;

@NoArgsConstructor
public class UserRepository implements CrudRepository<User> {
    private static final Map<Long, User> userMap = new HashMap<>();

    @Override
    public void addToRepository(Long id, User object) {
        userMap.putIfAbsent(id,object);
    }

    @Override
    public void deleteFromRepository(Long id) {
        userMap.remove(id);
    }

    @Override
    public User getFromRepositoryById(Long id) {
        return userMap.get(id);
    }
    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        for(Map.Entry<Long,User> entry : userMap.entrySet()){
            users.add(entry.getValue());
        }
        return users;
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
