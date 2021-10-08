package SplitwiseClone.repository;

import SplitwiseClone.entity.UserBalance;

import java.util.*;

public class UserBalancesRepository implements CrudRepository<UserBalance> {
    private static final Map<Long, UserBalance> userBalances = new HashMap<>();

    @Override
    public void add(Long id, UserBalance object) {
        userBalances.putIfAbsent(id,object);
    }

    @Override
    public void delete(Long id) {
        userBalances.remove(id);
    }

    @Override
    public UserBalance getById(Long id) {
        return userBalances.get(id);
    }

    @Override
    public boolean contains(Long id) {
        return userBalances.containsKey(id);
    }

    @Override
    public void deleteAll() {
        userBalances.clear();
    }

    @Override
    public List<UserBalance>getAll() {
        return new ArrayList<>(userBalances.values());
    }
}
