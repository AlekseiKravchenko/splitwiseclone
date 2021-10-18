package SplitwiseClone.entity.Expense;

import SplitwiseClone.repository.DebtsRepository;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

@Getter
@Setter
public class PercentExpense extends Expense {
    DebtsRepository dr = new DebtsRepository();
    private Map<Long,BigDecimal> percentValues;

    public PercentExpense(
            String description,
            BigDecimal amountOfExpense,
            Long userPaidById,
            LocalDateTime expenseDayTime,
            Long id,Map<Long,BigDecimal> percentValues
    ) {
        super(description, amountOfExpense, userPaidById, expenseDayTime,id);
        this.percentValues = percentValues;
    }
    public PercentExpense(
            String description,
            BigDecimal amountOfExpense,
            Long userPaidById,
            LocalDateTime expenseDayTime,
            Long id,Map<Long,BigDecimal> percentValues,
            Long groupId
    ) {
        super(description, amountOfExpense, userPaidById, expenseDayTime,id,groupId);
        this.percentValues = percentValues;
    }
}

