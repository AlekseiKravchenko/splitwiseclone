package SplitwiseClone.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.tuple.Pair;

import java.math.BigDecimal;
import java.util.List;
@AllArgsConstructor
@Getter
public class ExpensePercentModel {
    List<Pair<Long,Double>> userPercents;
    BigDecimal amount;
    Long ownUserId;
}
