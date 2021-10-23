package SplitwiseClone.services;

import SplitwiseClone.entity.Debt;
import SplitwiseClone.entity.Transaction;
import SplitwiseClone.model.ExpenseModel;

import java.util.List;

public interface ExpenseSplitter {
    List<Debt> split(ExpenseModel expense, Transaction transaction);
}
