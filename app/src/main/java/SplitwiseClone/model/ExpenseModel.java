package SplitwiseClone.model;

import SplitwiseClone.entity.enums.SplitType;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

@AllArgsConstructor
@Getter
public class ExpenseModel {
    private Map<Long, BigDecimal>usersDataForSplits;
    private LocalDateTime expenseDayTime;
    private SplitType splitType;
    private String description;
    private BigDecimal amount;
    private Long userPaidById;
    private Long ownUserId;
    private Long groupId;
}
