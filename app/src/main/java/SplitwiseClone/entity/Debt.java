package SplitwiseClone.entity;

import lombok.*;

import java.math.BigDecimal;
@Setter
@Getter
public class Debt {
    private BigDecimal amount;
    private Long expenseId;
    private Long groupId;
    private Long userId;
    private Long id;

    public Debt(BigDecimal amount, Long expenseId,Long id, Long userId){
        this.expenseId = expenseId;
        this.amount = amount;
        this.userId = userId;
        this.id = id;
    }
    public Debt(BigDecimal amount, Long expenseId, Long userId,Long id, Long groupId){
        this.expenseId = expenseId;
        this.groupId = groupId;
        this.amount = amount;
        this.userId = userId;
        this.id = id;
    }
}
