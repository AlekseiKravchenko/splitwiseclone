package SplitwiseClone.utils;

import SplitwiseClone.entity.Expense;
import SplitwiseClone.entity.ExpenseSplitType;
import SplitwiseClone.entity.Group;
import SplitwiseClone.entity.User;
import SplitwiseClone.services.ExpenseCalculateService;
import SplitwiseClone.services.ExpenseService;
import SplitwiseClone.services.GroupService;
import SplitwiseClone.services.UserService;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class GenerateMocData {
    public static void generateData() {
        ExpenseService es = new ExpenseService();
        UserService us = new UserService();
        GroupService gs = new GroupService();
        ExpenseCalculateService ecs = new ExpenseCalculateService();

        User user1 = us.createUser("aleksei", "kravchenko", "aswyga@gmail.com", "0502648096");
        User user2 = us.createUser("kolya", "shevcov", "asdas@gmail.com", "0501232323");
        User user3 = us.createUser("tolya", "savchenko", "asdasdas", "0501232323");

        Group group = gs.createGroup("family");
        gs.addUserToGroup(group.getId(), user1.getId());
        gs.addUserToGroup(group.getId(), user2.getId());
        gs.addUserToGroup(group.getId(), user3.getId());

        Expense expense = es.createExpense("lunch", new BigDecimal("500.00"), ExpenseSplitType.EQUAL, user1, LocalDateTime.now());
        es.addGroupUsersToExpense(group.getId(), expense.getExpenseId());
        es.addUserToExpense(user1.getId(), expense.getExpenseId());
        es.addUserToExpense(user2.getId(), expense.getExpenseId());
        es.addUserToExpense(user3.getId(), expense.getExpenseId());
        ecs.calculateEqualExpense(expense.getExpenseId());

        Expense expense2 = es.createExpense("Breakfast", new BigDecimal("1000.00"), ExpenseSplitType.PERCENT, user1, LocalDateTime.now());
        Map<Long, BigDecimal> percentValues = new HashMap<>();
        percentValues.put(user1.getId(), new BigDecimal("33.3333"));
        percentValues.put(user2.getId(), new BigDecimal("33.3333"));
        percentValues.put(user3.getId(), new BigDecimal("33.3333"));
        es.addGroupUsersToExpense(group.getId(), expense2.getExpenseId());
        ecs.calculatePercentExpense(expense2.getExpenseId(), percentValues);
    }
}
