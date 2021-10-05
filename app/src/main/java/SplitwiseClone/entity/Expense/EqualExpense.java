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
public class EqualExpense extends Expense {

    public EqualExpense(String description, BigDecimal amountOfExpense, Long userPaidById, LocalDateTime expenseDayTime, Long id) {
        super(description, amountOfExpense, userPaidById, expenseDayTime, id);
    }

    @Override
    public void calculateExpense() {
        Map<Long, BigDecimal> amountsOwed = new HashMap<>();
        Map<Long,BigDecimal> amountsPaid = new HashMap<>();
        BigDecimal count = new BigDecimal(getExpenseMembers().size());
        for (User expenseMember : getExpenseMembers()) {
            if(!getUserPaidById().equals(expenseMember.getId())) {
                BigDecimal amountOwes = getAmountOfExpense().divide(count,2, RoundingMode.UP);
                amountsOwed.put(expenseMember.getId(), amountOwes);
            } else {
                BigDecimal amountPaid = getAmountOfExpense().divide(count,2,RoundingMode.FLOOR);
                amountsPaid.put(expenseMember.getId(), amountPaid);
            }
        }
        setAmountsOwed(amountsOwed);
        setAmountsPaid(amountsPaid);
    }
}
