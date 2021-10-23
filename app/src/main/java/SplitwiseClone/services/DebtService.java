package SplitwiseClone.services;

import SplitwiseClone.entity.Debt;
import SplitwiseClone.repository.DebtsRepository;
import SplitwiseClone.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@RequiredArgsConstructor
public class DebtService {
    final TransactionRepository expenseRepository;
    final DebtsRepository debtsRepository;

    public Debt create(BigDecimal amount, Long expenseId, Long userId) {
        Debt debt = new Debt(amount, expenseId, userId);
        debtsRepository.add(debt);
        return debt;
    }
}
