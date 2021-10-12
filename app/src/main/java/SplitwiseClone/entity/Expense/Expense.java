package SplitwiseClone.entity.Expense;

import SplitwiseClone.entity.User;
import SplitwiseClone.repository.UserRepository;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ToString
@Getter
@Setter
public abstract class Expense {
    private LocalDateTime expenseDayTime;
    private BigDecimal amountOfExpense;
    private List<User>  expenseMembers;
    private String description;
    private Long userPaidById;
    private Long expenseId;
    private Long groupId;
    UserRepository ur;

    protected Expense(String description, BigDecimal amountOfExpense,
                   Long userPaidById,LocalDateTime expenseDayTime, Long expenseId) {
        this.expenseMembers = new ArrayList<>();
        this.amountOfExpense = amountOfExpense;
        this.expenseDayTime = expenseDayTime;
        this.userPaidById = userPaidById;
        this.description = description;
        this.expenseId = expenseId ;
    }
    protected Expense(String description, BigDecimal amountOfExpense,
                      Long userPaidById,LocalDateTime expenseDayTime, Long expenseId, Long groupId) {
        this.expenseMembers = new ArrayList<>();
        this.amountOfExpense = amountOfExpense;
        this.expenseDayTime = expenseDayTime;
        this.userPaidById = userPaidById;
        this.description = description;
        this.expenseId = expenseId ;
        this.groupId = groupId;
    }
    public abstract void calculateExpense();
}


