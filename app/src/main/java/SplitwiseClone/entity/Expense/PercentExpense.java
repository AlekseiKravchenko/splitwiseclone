package SplitwiseClone.entity.Expense;

import SplitwiseClone.entity.Debt;
import SplitwiseClone.entity.User;
import SplitwiseClone.repository.DebtsRepository;
import SplitwiseClone.utils.IdGenerator;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.Map;

@Getter
@Setter
public class PercentExpense extends Expense {
    DebtsRepository dr = new DebtsRepository();
    private Map<Long,BigDecimal> percentValues;

    public PercentExpense(String description, BigDecimal amountOfExpense, Long userPaidById,
                          LocalDateTime expenseDayTime,
                          Long id,Map<Long,BigDecimal> percentValues) {
        super(description, amountOfExpense, userPaidById, expenseDayTime,id);
        this.percentValues = percentValues;
    }
    public PercentExpense(String description, BigDecimal amountOfExpense, Long userPaidById,
                          LocalDateTime expenseDayTime,
                          Long id,Map<Long,BigDecimal> percentValues, Long groupId) {
        super(description, amountOfExpense, userPaidById, expenseDayTime,id,groupId);
        this.percentValues = percentValues;
    }
    @Override
    public void calculateExpense() {
        BigDecimal oneHundred = new BigDecimal("100.00");
        for (User expenseMember : getExpenseMembers()) {
            BigDecimal amountOwes = getAmountOfExpense()
                    .multiply(percentValues.get(expenseMember.getId())).divide(oneHundred,2, RoundingMode.UP);
            Debt debt;
            if(getGroupId() != null) {
                debt = new Debt(amountOwes, getExpenseId(), expenseMember.getId(), IdGenerator.generateDebtId(), getGroupId());
            } else {
                debt = new Debt(amountOwes, getExpenseId(),IdGenerator.generateDebtId(), expenseMember.getId());
            }
            dr.add(debt.getId(),debt);
        }
    }
}

