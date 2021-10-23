package SplitwiseClone.services;

import SplitwiseClone.entity.Debt;
import SplitwiseClone.entity.Transaction;
import SplitwiseClone.model.ExpenseModel;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class EqualSplit implements ExpenseSplitter {
    @Override
    public List<Debt> split(ExpenseModel expense, Transaction transaction) {

        List<Debt> usersDebts = expense.getUsersDataForSplits().keySet().stream()
                .filter(userId -> !Objects.equals(userId, expense.getOwnUserId()))
                .map(userId -> getDebt(
                        expense.getAmount(),
                        userId,
                        transaction.getId(),
                        expense.getUsersDataForSplits().keySet().size()))
                .collect(Collectors.toList());

        BigDecimal userTotalAmount = usersDebts.stream()
                .map(Debt::getAmount)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);

        BigDecimal ownerAmount = expense.getAmount().subtract(userTotalAmount);
        Debt ownerDebt = new Debt(ownerAmount, transaction.getId(), expense.getOwnUserId());
        usersDebts.add(ownerDebt);
        return usersDebts;
    }

    private Debt getDebt(BigDecimal amount, Long userId, Long expenseId, Integer countUsers) {
        BigDecimal debtAmount = amount.divide(BigDecimal.valueOf(countUsers), 2, RoundingMode.HALF_UP);
        return new Debt(debtAmount, expenseId, userId);
    }
}
