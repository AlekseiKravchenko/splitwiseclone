package SplitwiseClone.services;

import SplitwiseClone.entity.Debt;
import SplitwiseClone.entity.Expense.Expense;
import SplitwiseClone.entity.Group;
import SplitwiseClone.entity.User;
import SplitwiseClone.model.ExpensePercentModel;
import SplitwiseClone.repository.DebtsRepository;
import SplitwiseClone.repository.ExpenseRepository;
import SplitwiseClone.utils.IdGenerator;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ExpenseServiceTest {
    final ExpenseRepository expenseRepository = new ExpenseRepository();
    final ExpenseService expenseService =  new ExpenseService();
    final UserService userService = new UserService();
    final DebtsRepository debtsRepository = new DebtsRepository();
    final DebtService debtService = new DebtService(expenseRepository,debtsRepository);
    @BeforeEach
    void deleteData(){
        expenseRepository.deleteAll();
    }
    @Test
    @DisplayName("Create  percent expense and put to repository")
    void createPercentExpense(){
        User user = new User("Aleksei", "Kravchenko", "aswyga@gmail.com",
                "050 264 80 96",IdGenerator.generateUserId());
        Map<Long,BigDecimal> percentages = new HashMap<>();
        expenseService.createPercentExpense("Lunch", new BigDecimal("500"), user.getId(), LocalDateTime.now(),percentages);
        assertEquals(1, expenseRepository.getAll().size());
    }
    @Test
    @DisplayName("Create  expense and put to repository")
    void Expense(){
        User user = new User("Aleksei", "Kravchenko", "aswyga@gmail.com",
                "050 264 80 96",IdGenerator.generateUserId());
        expenseService.createEqualExpense("Lunch", new BigDecimal("500"), user.getId(), LocalDateTime.now());
        assertEquals(1, expenseRepository.getAll().size());
    }

    @Test
    @DisplayName("check adding user to expense")
    void addUserToExpense(){
        User user = userService.create("Aleksei", "Kravchenko", "aswyga@gmail.com",
                "050 264 80 96");
        Expense expense  = expenseService.createEqualExpense("Lunch", new BigDecimal("500"), user.getId(), LocalDateTime.now());
        expenseService.addUserToExpense(user.getId(),expense.getExpenseId());
        assertEquals(1, expenseRepository.getById(expense.getExpenseId()).getExpenseMembers().size());
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
        Expense expense  = expenseService.createEqualExpense("Lunch", new BigDecimal("500"), user.getId(), LocalDateTime.now());
        expenseService.addGroupUsersToExpense(group.getId(), expense.getExpenseId());
        assertEquals(2, expenseRepository.getById(expense.getExpenseId()).getExpenseMembers().size());
    }
    @Test
    @DisplayName(" ")
    void shouldGetDebtsFromPercentExpense(){
        ExpensePercentModel expense = new ExpensePercentModel(
                List.of(
                         Pair.of(1L,33.0),
                         Pair.of(2L,33.0),
                         Pair.of(3L,33.0)
                ),
                 BigDecimal.valueOf(100),
                1L
        );
        List<Debt> result = debtService.getPercentDebts(expense,1L);
        assertEquals(3, result.size());
        assertAll(
                () -> assertEquals(0,BigDecimal.valueOf(33.000).compareTo(result.stream().
                        filter(debt -> debt.getUserId().equals(2L)).findFirst().get().getAmount())),
                () -> assertEquals(0,BigDecimal.valueOf(33.000).compareTo(result.stream().
                        filter(debt -> debt.getUserId().equals(2L)).findFirst().get().getAmount())),
                () -> assertEquals(0,BigDecimal.valueOf(34.000).compareTo(result.stream().
                        filter(debt -> debt.getUserId().equals(1L)).findFirst().get().getAmount()))
        );
    }
}