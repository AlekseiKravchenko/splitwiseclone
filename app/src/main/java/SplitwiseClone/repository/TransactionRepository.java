package SplitwiseClone.repository;

import SplitwiseClone.entity.Transaction;
import SplitwiseClone.utils.IdGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransactionRepository implements CrudRepository<Transaction> {
    private static final Map<Long, Transaction> expenseMap = new HashMap<>();

    @Override
    public void add(Transaction object) {
        object.setId(IdGenerator.generateDebtId());
        expenseMap.putIfAbsent(object.getId(), object);
    }

    @Override
    public void delete(Long id) {
        expenseMap.remove(id);
    }

    @Override
    public Transaction getById(Long id) {
        return expenseMap.get(id);
    }

    @Override
    public boolean contains(Long id) {
        return expenseMap.containsKey(id);
    }

    @Override
    public void deleteAll() {
        expenseMap.clear();
    }

    @Override
    public List<Transaction> getAll() {
        return new ArrayList<>(expenseMap.values());
    }
}
