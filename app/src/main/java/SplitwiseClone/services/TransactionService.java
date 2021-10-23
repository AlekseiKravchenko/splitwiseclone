package SplitwiseClone.services;

import SplitwiseClone.entity.Transaction;
import SplitwiseClone.model.ExpenseModel;
import SplitwiseClone.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TransactionService {
    private final TransactionRepository transactionRepository;

    public Transaction create(ExpenseModel expenseModel) {
        Transaction transaction = new Transaction(
                expenseModel.getDescription(),
                expenseModel.getAmount(),
                expenseModel.getOwnUserId(),
                expenseModel.getExpenseDayTime());
        transactionRepository.add(transaction);
        return transaction;
    }
}
