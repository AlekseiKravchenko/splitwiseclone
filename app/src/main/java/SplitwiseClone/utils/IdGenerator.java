package SplitwiseClone.utils;

public final class IdGenerator {
    private static Long userIdCount = 0L;
    private static Long groupIdCount = 0L;
    private static Long transactionIdCount = 0L;
    private static Long debtIdCount = 0L;
    private static Long settleUpCount = 0L;

    public static Long generateUserId() {
        return ++userIdCount;
    }

    public static Long generateGroupId() {
        return ++groupIdCount;
    }

    public static Long generateTransactionId() {
        return ++transactionIdCount;
    }

    public static Long generateDebtId() {
        return ++debtIdCount;
    }

    public static Long generateSettleUpId() {
        return ++settleUpCount;
    }

    public static Long getUserIdCount() {
        return userIdCount;
    }

    public static Long getGroupIdCount() {
        return groupIdCount;
    }

    public static Long getTransactionIdCount() {
        return transactionIdCount;
    }

}
