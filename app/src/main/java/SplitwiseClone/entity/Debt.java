package SplitwiseClone.entity;

import lombok.*;

import java.math.BigDecimal;
@Setter
@Getter
@RequiredArgsConstructor
public class Debt {
    private BigDecimal amount;
    private Long expenseId;
    private Long userId;
    private Long id;

    public Debt(BigDecimal amount, Long expenseId,Long debtId, Long userId){
        this.expenseId = expenseId;
        this.amount = amount;
        this.userId = userId;
        this.id = debtId;
    }
}
