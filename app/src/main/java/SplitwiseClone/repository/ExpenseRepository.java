package SplitwiseClone.repository;

import SplitwiseClone.entity.Expense.Expense;

import java.util.*;
public class ExpenseRepository implements CrudRepository<Expense> {
    private static final Map<Long, Expense> expenseMap = new HashMap<>();

    @Override
    public void add(Long id, Expense object) {
        expenseMap.putIfAbsent(id,object);
    }

    @Override
    public void delete(Long id) {
        expenseMap.remove(id);
    }

    @Override
    public Expense getById(Long id) {
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
    public List<Expense> getAll() {
        return new ArrayList<>(expenseMap.values());
    }
}
