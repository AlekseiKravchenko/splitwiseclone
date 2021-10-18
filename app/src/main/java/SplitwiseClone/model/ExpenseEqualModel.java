package SplitwiseClone.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;
@AllArgsConstructor
@Getter
public class ExpenseEqualModel {
    List<Long> userIds;
    BigDecimal amount;
    Long ownUserId;
}
