package SplitwiseClone.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;
class IdGeneratorTest {
    @BeforeEach
    void deleteData(){
      IdGenerator.expenseIdCount = 0L;
      IdGenerator.groupIdCount = 0L;
      IdGenerator.userIdCount = 0L;
    }
    @Test
    @DisplayName("Check generation of User Ids must be 1 ")
    void generateUserId() {
        assertEquals(Long.valueOf(1L),IdGenerator.generateUserId());
    }

    @Test
    @DisplayName("Check generation of Group Ids must be 1 ")
    void generateGroupId() {
        assertEquals(Long.valueOf(1L),IdGenerator.generateGroupId());
    }

    @Test
    @DisplayName("Check generation of Group Ids must be 1 ")
    void generateExpenseId() {
        assertEquals(Long.valueOf(1L),IdGenerator.generateExpenseId());
    }
}