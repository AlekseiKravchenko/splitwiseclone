package SplitwiseClone;

import SplitwiseClone.entity.*;
import SplitwiseClone.repository.ExpenseRepository;
import SplitwiseClone.repository.GroupRepository;
import SplitwiseClone.repository.UserRepository;
import SplitwiseClone.services.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

class Main {
    public static void main(String[] args) {
        ExpenseService es = new ExpenseService();
        UserService us = new UserService();
        GroupService gs = new GroupService();

        User user1 = us.createUser("aleksei","kravchenko","aswyga@gmail.com","0502648096");
        User user2 = us.createUser("kolya","shevcov","asdas@gmail.com","0501232323");
        User user3 = us.createUser("tolya","savchenko","asdasdas","0501232323");

        Group group = gs.createGroup("family");
        gs.addUserToGroup(group,user1);
        gs.addUserToGroup(group,user2);
        gs.addUserToGroup(group,user3);

        Expense expense = es.createExpense("lunch",BigDecimal.valueOf(500L),ExpenseSplitType.EQUAL,user1,LocalDateTime.now());
        es.addGroupUsersToExpense(group,expense.getExpenseId());
        es.addUserToExpense(user1,expense.getExpenseId());
        es.addUserToExpense(user2,expense.getExpenseId());
        es.addUserToExpense(user3,expense.getExpenseId());

        System.out.println(UserRepository.userMap);
        System.out.println(GroupRepository.groupMap);
        System.out.println(ExpenseRepository.expenseMap);
    }
}