package SplitwiseClone.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IdGeneratorTest {
    @Test
    @DisplayName("Check generation of User Ids")
    void generateUserId() {
        Long result = IdGenerator.getUserIdCount() + 1;
        assertEquals(result, IdGenerator.generateUserId());
    }

    @Test
    @DisplayName("Check generation of Group Ids")
    void generateGroupId() {
        Long result = IdGenerator.getGroupIdCount() + 1;
        assertEquals(result, IdGenerator.generateGroupId());
    }

    @Test
    @DisplayName("Check generation of Expense Ids")
    void generateExpenseId() {
        Long result = IdGenerator.getTransactionIdCount() + 1;
        assertEquals(result, IdGenerator.generateTransactionId());
    }
}