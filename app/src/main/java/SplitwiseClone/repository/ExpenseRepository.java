package SplitwiseClone.repository;

import SplitwiseClone.entity.Expense.Expense;

import java.util.*;
public class ExpenseRepository implements CrudRepository<Expense> {
    private static final Map<Long, Expense> expenseMap = new HashMap<>();

    @Override
    public void addToRepository(Long id, Expense object) {
        expenseMap.putIfAbsent(id,object);
    }

    @Override
    public void deleteFromRepository(Long id) {
        expenseMap.remove(id);
    }

    @Override
    public Expense getFromRepositoryById(Long id) {
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
        List<Expense> expenseList = new ArrayList();
        for(Map.Entry<Long,Expense> entry : expenseMap.entrySet()){
            expenseList.add(entry.getValue());
        }
        return expenseList;
    }
}
