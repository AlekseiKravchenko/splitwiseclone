package SplitwiseClone.entity;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ToString
@Getter
@Setter
public class Expense {
    private Long id;
    static private Long count = 1L;
    private String description;
    private BigDecimal amountOfExpense;
    private ExpenseSplitType splitType;
    private User paidBy;
    private LocalDateTime expenseDayTime;

    public Expense(String description, BigDecimal amountOfExpense,
                   ExpenseSplitType splitType, User paidBy,
                   LocalDateTime expenseDayTime) {
        this.description = description;
        this.amountOfExpense = amountOfExpense;
        this.expenseDayTime = expenseDayTime;
        this.splitType = splitType;
        this.paidBy = paidBy;
        this.id = count;
        count++;
    }
}


