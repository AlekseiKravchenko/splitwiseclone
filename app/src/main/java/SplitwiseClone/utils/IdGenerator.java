package SplitwiseClone.utils;

public class IdGenerator {
        private static Long userIdCount = 0L;
        private static Long groupIdCount = 0L;
        private static Long expenseIdCount = 0L;

        public static Long generateUserId() {
            userIdCount++;
            return userIdCount;
        }
        public static Long generateGroupId() {
            groupIdCount++;
            return groupIdCount;
        }
        public static Long generateExpenseId() {
            expenseIdCount++;
            return expenseIdCount;
        }
}
