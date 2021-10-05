package SplitwiseClone.utils;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public final  class IdGenerator {
    public static Long userIdCount = 0L;
    public static Long groupIdCount = 0L;
    public static Long expenseIdCount = 0L;

        public static Long generateUserId() {
            return ++userIdCount;
        }
        public static Long generateGroupId() {
            return ++groupIdCount;
        }
        public static Long generateExpenseId() {
            return ++expenseIdCount;
        }
}
