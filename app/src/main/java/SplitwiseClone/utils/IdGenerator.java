package SplitwiseClone.utils;


import lombok.NoArgsConstructor;
@NoArgsConstructor
public final  class IdGenerator {
     private static Long userIdCount = 0L;
     private static Long groupIdCount = 0L;
     private static Long expenseIdCount = 0L;
     private static Long debtIdCount = 0L;

        public static Long generateUserId() {
            return ++userIdCount;
        }
        public static Long generateGroupId() {
            return ++groupIdCount;
        }
        public static Long generateExpenseId() {
            return ++expenseIdCount;
        }
        public static Long generateDebtId() {
        return ++debtIdCount;
     }

    public static Long getUserIdCount() {
        return userIdCount;
    }

    public static Long getGroupIdCount() {
        return groupIdCount;
    }

    public static Long getExpenseIdCount() {
        return expenseIdCount;
    }
    public static Long getDebtIdCount() {
            return debtIdCount;
    }
}
