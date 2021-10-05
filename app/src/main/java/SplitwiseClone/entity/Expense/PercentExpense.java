package SplitwiseClone.entity.Expense;

import SplitwiseClone.entity.User;
import lombok.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class PercentExpense extends Expense {
    private Map<Long,BigDecimal> percentValues;

    public PercentExpense(String description, BigDecimal amountOfExpense, Long userPaidById,
                          LocalDateTime expenseDayTime,
                          Long id,Map<Long,BigDecimal> percentValues) {
        super(description, amountOfExpense, userPaidById, expenseDayTime,id);
        this.percentValues = percentValues;
    }

    @Override
    public void calculateExpense() {
        Map<Long,BigDecimal> amountsOwed = new HashMap<>();
        Map<Long,BigDecimal> amountsPaid = new HashMap<>();
        BigDecimal oneHundred = new BigDecimal("100.00");
        for (User expenseMember : getExpenseMembers()) {
            if(!getUserPaidById().equals(expenseMember.getId())) {
                BigDecimal amountOwes = getAmountOfExpense()
                        .multiply(percentValues.get(expenseMember.getId())).divide(oneHundred,2, RoundingMode.UP);
                amountsOwed.put(expenseMember.getId(),amountOwes);
            } else {
                BigDecimal amountPaid = getAmountOfExpense()
                        .multiply(percentValues.get(expenseMember.getId())).divide(oneHundred,2,RoundingMode.UP);
                amountsPaid.put(expenseMember.getId(), amountPaid);
            }
            setAmountsOwed(amountsOwed);
            setAmountsPaid(amountsPaid);
        }
    }
}

