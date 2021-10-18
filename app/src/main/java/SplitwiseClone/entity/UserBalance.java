package SplitwiseClone.entity;

import lombok.*;

import java.math.BigDecimal;
import java.util.*;
@Getter
@Setter
@AllArgsConstructor
public class UserBalance {
    private Long userBalanceId;
    private Map<Long,BigDecimal> balanceWithUsers;
}
