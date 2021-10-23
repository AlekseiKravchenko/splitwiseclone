package SplitwiseClone.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class UserBalance {
    private Long userBalanceId;
    private Map<Long, BigDecimal> balanceWithUsers;
}
