package SplitwiseClone.entity.Expense;

import SplitwiseClone.repository.DebtsRepository;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
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

//    public void calculateExpense() {
//        Debt debt;
//        BigDecimal count = new BigDecimal(getExpenseMembers().size());
//
//        for (User expenseMember : getExpenseMembers()) {
//            BigDecimal amountOwes = getAmountOfExpense().divide(count,2, RoundingMode.UP);
//            if(getGroupId() != null) {
//                debt = new Debt(amountOwes, getExpenseId(), expenseMember.getId(), IdGenerator.generateDebtId(), getGroupId());
//            } else {
//                debt = new Debt(amountOwes, getExpenseId(),IdGenerator.generateDebtId(), expenseMember.getId());
//            }
//            dr.add(debt.getId(),debt);
//        }
//    }
}