package SplitwiseClone.services;

import SplitwiseClone.entity.Debt;
import SplitwiseClone.model.ExpenseEqualModel;
import SplitwiseClone.model.ExpensePercentModel;
import SplitwiseClone.repository.DebtsRepository;
import SplitwiseClone.repository.ExpenseRepository;
import SplitwiseClone.utils.IdGenerator;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.tuple.Pair;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class DebtService {
    final ExpenseRepository expenseRepository;
    final DebtsRepository debtsRepository;

    public Debt createDebt(BigDecimal amount, Long expenseId,Long userId) {
        Debt debt = new Debt(amount,expenseId, IdGenerator.generateDebtId(),userId);
        debtsRepository.add(debt.getId(), debt);
        return debt;
    }
    public List<Debt> getPercentDebts(ExpensePercentModel expense, Long expenseId) {
        List<Debt> usersDebts = expense.getUserPercents().stream()
                .filter(userPercent -> !Objects.equals(userPercent.getLeft(), expense.getOwnUserId()))
                .map(userPercent -> getPercentDebt(expense.getAmount(), userPercent, expenseId))
                .collect(Collectors.toList());
        BigDecimal userTotalAmount = usersDebts.stream()
                .map(Debt::getAmount)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
        BigDecimal ownerAmount = expense.getAmount().subtract(userTotalAmount);
        Debt ownerDebt = new Debt(ownerAmount,expenseId,IdGenerator.generateDebtId(),expense.getOwnUserId());
        usersDebts.add(ownerDebt);
        return usersDebts;
    }
    public List<Debt> getEqualDebts(ExpenseEqualModel expense, Long expenseId) {
        List<Debt> usersDebts = expense.getUserIds().stream()
                .filter(userId -> !Objects.equals(userId, expense.getOwnUserId()))
                .map(userId -> getDebt(expense.getAmount(), userId,expenseId, expense.getUserIds().size()))
                .collect(Collectors.toList());
        BigDecimal userTotalAmount = usersDebts.stream()
                .map(Debt::getAmount)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
        BigDecimal ownerAmount = expense.getAmount().subtract(userTotalAmount);
        Debt ownerDebt = createDebt(ownerAmount,expenseId,expense.getOwnUserId());
        usersDebts.add(ownerDebt);
        return usersDebts;
    }
    private Debt getDebt(BigDecimal amount,Long userId,Long expenseId, Integer countUsers) {
       BigDecimal debtAmount = amount.divide(BigDecimal.valueOf(countUsers),2,RoundingMode.HALF_UP);
       return createDebt(debtAmount,expenseId,userId);
    }
    private Debt getPercentDebt(BigDecimal amount, Pair<Long,Double> userPercent, Long expenseId) {
        BigDecimal debtAmount = amount.divide(BigDecimal.valueOf(100),2, RoundingMode.HALF_UP)
                .multiply(BigDecimal.valueOf(userPercent.getRight()));
        return createDebt(debtAmount,expenseId,userPercent.getLeft());
    }
}
