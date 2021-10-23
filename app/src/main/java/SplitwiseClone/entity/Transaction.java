package SplitwiseClone.entity;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class Transaction {
    private LocalDateTime transactionTime;
    private String description;
    private BigDecimal amount;
    private Long ownerId;
    private Long id;

    public Transaction(String description, BigDecimal amount, Long ownerId, LocalDateTime transactionTime) {
        this.transactionTime = transactionTime;
        this.description = description;
        this.amount = amount;
        this.ownerId = ownerId;
    }
}
