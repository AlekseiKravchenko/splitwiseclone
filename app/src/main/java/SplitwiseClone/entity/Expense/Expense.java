package SplitwiseClone.entity.Expense;

import SplitwiseClone.entity.User;
import SplitwiseClone.repository.*;
import java.time.LocalDateTime;
import java.math.BigDecimal;
import java.util.*;
import lombok.*;

@ToString
@Getter
@Setter
abstract public class Expense {
    private Map<Long, BigDecimal> amountsOwed = new HashMap<>();
    private Map<Long,BigDecimal> amountsPaid = new HashMap<>();
    private LocalDateTime expenseDayTime;
    private BigDecimal amountOfExpense;
    private List<User>  expenseMembers;
    private String description;
    private Long userPaidById;
    private Long expenseId;

    protected Expense(String description, BigDecimal amountOfExpense,
                   Long userPaidById,LocalDateTime expenseDayTime, Long id) {
        this.expenseMembers = new ArrayList<>();
        this.amountOfExpense = amountOfExpense;
        this.expenseDayTime = expenseDayTime;
        this.userPaidById = userPaidById;
        this.description = description;
        this.expenseId = id ;
    }

    public void addMember(Long userId){
        this.expenseMembers.add(UserRepository.userMap.get(userId));
    }
    abstract public void calculateExpense();
}


