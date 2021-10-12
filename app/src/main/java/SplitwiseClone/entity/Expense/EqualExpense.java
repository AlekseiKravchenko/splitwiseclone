package SplitwiseClone.entity.Expense;

import SplitwiseClone.entity.Debt;
import SplitwiseClone.entity.User;
import SplitwiseClone.repository.DebtsRepository;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;

@Getter
@Setter
public class EqualExpense extends Expense {
    DebtsRepository dr = new DebtsRepository();
    public EqualExpense(String description, BigDecimal amountOfExpense, Long userPaidById, LocalDateTime expenseDayTime, Long id) {
        super(description, amountOfExpense, userPaidById, expenseDayTime, id);
    }
    public EqualExpense(String description, BigDecimal amountOfExpense, Long userPaidById, LocalDateTime expenseDayTime, Long id, Long groupId) {
        super(description, amountOfExpense, userPaidById, expenseDayTime, id,groupId);
    }

    @Override
    public void calculateExpense() {
        Debt debt;
        BigDecimal count = new BigDecimal(getExpenseMembers().size());
        BigDecimal amountOwes = getAmountOfExpense().divide(count,2, RoundingMode.UP);
        for (User expenseMember : getExpenseMembers()) {
            if(getGroupId() != null) {
                debt = new Debt(amountOwes, getExpenseId(), getUserPaidById(), getGroupId());
            } else {
                debt = new Debt(amountOwes, getExpenseId(), getUserPaidById());
            }
            dr.add(debt.getId(),debt);
        }
    }
}
