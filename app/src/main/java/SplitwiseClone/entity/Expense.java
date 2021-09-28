package SplitwiseClone.entity;
import SplitwiseClone.repository.GroupRepository;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@ToString
@Getter
@Setter
public class Expense {
    private LocalDateTime expenseDayTime;
    private BigDecimal amountOfExpense;
    private ExpenseSplitType splitType;
    static private Long count = 1L;
    private String description;
    private List<User>  members;
    private User paidBy;
    private Long expenseId;

    public Expense(String description, BigDecimal amountOfExpense,
                   ExpenseSplitType splitType, User paidBy,
                   LocalDateTime expenseDayTime) {
        this.amountOfExpense = amountOfExpense;
        this.expenseDayTime = expenseDayTime;
        this.description = description;
        this.splitType = splitType;
        this.members = new ArrayList<>();
        this.expenseId = count;
        this.paidBy = paidBy;
        count++;
    }
    public void addMember(User user){
        this.members.add(user);
    }
    public void addGroupMembers(Group group) {
        this.members = GroupRepository.groupMembers.get(group);
    }
}


