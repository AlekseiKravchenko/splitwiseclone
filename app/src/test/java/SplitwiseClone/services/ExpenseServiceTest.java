package SplitwiseClone.services;

import SplitwiseClone.entity.Expense.Expense;
import SplitwiseClone.entity.Group;
import SplitwiseClone.entity.User;
import SplitwiseClone.repository.*;
import SplitwiseClone.utils.IdGenerator;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;


import static org.junit.jupiter.api.Assertions.*;

class ExpenseServiceTest {
    ExpenseRepository er = new ExpenseRepository();
    ExpenseService es =  new ExpenseService();
    UserService us = new UserService();
    @BeforeEach
    void deleteData(){
        er.deleteAll();
    }
    @Test
    @DisplayName("Create  percent expense and put to repository")
    void createPercentExpense(){
        User user = new User("Aleksei", "Kravchenko", "aswyga@gmail.com",
                "050 264 80 96",IdGenerator.generateUserId());
        Map<Long,BigDecimal> percentages = new HashMap<>();
        es.createExpense("Lunch", new BigDecimal("500"), user.getId(), LocalDateTime.now(),percentages);
        assertEquals(1,er.getAll().size());
    }
    @Test
    @DisplayName("Create  expense and put to repository")
    void Expense(){
        User user = new User("Aleksei", "Kravchenko", "aswyga@gmail.com",
                "050 264 80 96",IdGenerator.generateUserId());
        es.createExpense("Lunch", new BigDecimal("500"), user.getId(), LocalDateTime.now());
        assertEquals(1,er.getAll().size());
    }

    @Test
    @DisplayName("check adding user to expense")
    void addUserToExpense(){
        User user = us.createUser("Aleksei", "Kravchenko", "aswyga@gmail.com",
                "050 264 80 96");
        Expense expense  = es.createExpense("Lunch", new BigDecimal("500"), user.getId(), LocalDateTime.now());
        es.addUserToExpense(expense.getExpenseId(), user.getId());
        assertEquals(1,er.getFromRepositoryById(expense.getExpenseId()).getExpenseMembers().size());
    }
    @Test
    @DisplayName("check adding List users to expense")
    void addListUsersToExpense(){
        GroupService gp = new GroupService();
        User user = new User("Aleksei", "Kravchenko", "aswyga@gmail.com",
                "050 264 80 96",IdGenerator.generateUserId());
        User user2 = new User("Aleksei", "Kravchenko", "aswyga@gmail.com",
                "050 264 80 96",IdGenerator.generateUserId());
        User user3 = new User("Aleksei", "Kravchenko", "aswyga@gmail.com",
                "050 264 80 96",IdGenerator.generateUserId());
        Group group = gp.createGroup("Co-Workers");
        group.getGroupMembers().add(user2);
        group.getGroupMembers().add(user3);
        Expense expense  = es.createExpense("Lunch", new BigDecimal("500"), user.getId(), LocalDateTime.now());
        es.addGroupUsersToExpense(group.getId(), expense.getExpenseId());
        assertEquals(2,er.getFromRepositoryById(expense.getExpenseId()).getExpenseMembers().size());
    }
}