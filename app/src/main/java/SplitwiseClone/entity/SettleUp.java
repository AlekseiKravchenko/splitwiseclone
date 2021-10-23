package SplitwiseClone.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class SettleUp {
    private BigDecimal amount;
    private Long ownerId;
    private Long userId;
    private Long Id;

    public SettleUp(BigDecimal amount, Long ownerId, Long userId) {
        this.amount = amount;
        this.ownerId = ownerId;
        this.userId = userId;
    }
}

