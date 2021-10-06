package SplitwiseClone.repository;

import SplitwiseClone.entity.UserBalance;

import java.util.*;

public class UserBalancesRepository implements CrudRepository<UserBalance> {
    private static Map<Long, UserBalance> userBalances = new HashMap<>();

    @Override
    public void addToRepository(Long id, UserBalance object) {
        userBalances.putIfAbsent(id,object);
    }

    @Override
    public void deleteFromRepository(Long id) {
        userBalances.remove(id);
    }

    @Override
    public UserBalance getFromRepositoryById(Long id) {
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
        List<UserBalance> balances = new ArrayList<>();
        for(Map.Entry<Long,UserBalance> entry : userBalances.entrySet()) {
            balances.add(entry.getValue());
        }
        return balances;
    }
}
