package SplitwiseClone.entity;

import SplitwiseClone.repository.GroupRepository;
import SplitwiseClone.repository.UserRepository;
import java.time.LocalDateTime;
import java.math.BigDecimal;
import java.util.*;
import lombok.*;

@ToString
@Getter
@Setter
public class Expense {
    private Map<User, BigDecimal> amountsOwed = new HashMap<>();
    private Map<User,BigDecimal> amountsPaid = new HashMap<>();
    private LocalDateTime expenseDayTime;
    private BigDecimal amountOfExpense;
    private ExpenseSplitType splitType;
    private Set<User>  expenseMembers;
    private String description;
    private Long expenseId;
    private User paidBy;

    public Expense(String description, BigDecimal amountOfExpense,
                   ExpenseSplitType splitType, User paidBy,
                   LocalDateTime expenseDayTime, Long id) {
        this.expenseMembers = new HashSet<>();
        this.amountOfExpense = amountOfExpense;
        this.expenseDayTime = expenseDayTime;
        this.description = description;
        this.splitType = splitType;
        this.paidBy = paidBy;
        this.expenseId = id ;
    }

    public void addMember(Long userId){
        this.expenseMembers.add(UserRepository.userMap.get(userId));
    }
}


