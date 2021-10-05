package SplitwiseClone.entity;

import lombok.*;

import java.math.BigDecimal;
import java.util.*;
@Getter
@Setter
public class UserBalance {
    Long userBalanceId;
    Map<Long,BigDecimal> balanceWithUsers;

    public UserBalance(Long userBalanceId){
        this.userBalanceId = userBalanceId;
        this.balanceWithUsers = new HashMap<>();
    }
}
