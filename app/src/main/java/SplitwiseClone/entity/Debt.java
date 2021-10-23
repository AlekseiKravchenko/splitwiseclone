package SplitwiseClone.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@RequiredArgsConstructor
public class Debt {
    private BigDecimal amount;
    private Long transactionId;
    private Long groupId;
    private Long userId;
    private Long id;

    public Debt(BigDecimal amount, Long transactionId, Long userId) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.userId = userId;
    }
}
