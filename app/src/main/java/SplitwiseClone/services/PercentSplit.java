package SplitwiseClone.services;

import SplitwiseClone.entity.Debt;
import SplitwiseClone.entity.Transaction;
import SplitwiseClone.model.ExpenseModel;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class PercentSplit implements ExpenseSplitter{
    @Override
    public List<Debt> split(ExpenseModel expense, Transaction transaction) {
        List<Debt> usersDebts = expense.getUsersDataForSplits().entrySet().stream()
                .filter(entry -> !Objects.equals(entry.getKey(), expense.getOwnUserId()))
                .map(userPercent -> getPercentDebt(expense.getAmount(), userPercent, transaction.getId()))
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
    private Debt getPercentDebt(BigDecimal amount, Map.Entry<Long,BigDecimal> userPercent, Long transactionId) {
        BigDecimal debtAmount = amount.divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP)
                .multiply(userPercent.getValue());
        return new Debt(debtAmount, transactionId, userPercent.getKey());
    }
}
