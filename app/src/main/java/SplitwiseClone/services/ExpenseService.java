package SplitwiseClone.services;

import SplitwiseClone.entity.Debt;
import SplitwiseClone.entity.Expense.EqualExpense;
import SplitwiseClone.entity.Expense.Expense;
import SplitwiseClone.entity.Expense.PercentExpense;
import SplitwiseClone.model.ExpensePercentModel;
import SplitwiseClone.repository.ExpenseRepository;
import SplitwiseClone.repository.GroupRepository;
import SplitwiseClone.repository.UserRepository;
import SplitwiseClone.utils.IdGenerator;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.tuple.Pair;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@NoArgsConstructor
public class ExpenseService {
    ExpenseRepository expenseRepository = new ExpenseRepository();
    UserRepository userRepository = new UserRepository();
    GroupRepository groupRepository = new GroupRepository();
        public Expense createEqualExpense(String description, BigDecimal amountOfExpense, Long userPaidById,
                                     LocalDateTime expenseDayTime) {
            Expense expense = new EqualExpense(description,amountOfExpense,userPaidById,
                    expenseDayTime, IdGenerator.generateExpenseId());
            expenseRepository.add(expense.getExpenseId(),expense);
            return expense;
        }
        public Expense createEqualGroupExpense(String description, BigDecimal amountOfExpense, Long userPaidById,
                                          LocalDateTime expenseDayTime, Long groupId) {
            Expense expense = new EqualExpense(description,amountOfExpense,userPaidById,
                    expenseDayTime, IdGenerator.generateExpenseId(),groupId);
            expenseRepository.add(expense.getExpenseId(),expense);
            return expense;
        }


        public Expense createPercentExpense(String description, BigDecimal amountOfExpense,
                                            Long userPaidById,LocalDateTime expenseDayTime,
                                            Map<Long,BigDecimal> percentValues) {
        Expense expense = new PercentExpense(description,amountOfExpense,userPaidById,
                expenseDayTime, IdGenerator.generateExpenseId(),percentValues);
            expenseRepository.add(expense.getExpenseId(),expense);
        return expense;
        }
        public Expense createPercentGroupExpense(String description, BigDecimal amountOfExpense,
                                                 Long userPaidById,LocalDateTime expenseDayTime,
                                                 Map<Long,BigDecimal> percentValues, Long groupId) {
            Expense expense = new PercentExpense(description,amountOfExpense,userPaidById,
                    expenseDayTime, IdGenerator.generateExpenseId(),percentValues,groupId);
            expenseRepository.add(expense.getExpenseId(),expense);
            return expense;
        }




        public void addUserToExpense(Long userId, Long expenseId) {
            if(expenseRepository.contains(expenseId)) {
                expenseRepository.getById(expenseId).getExpenseMembers().add(userRepository.getById(userId));
            } else {
                System.out.println("This expense does not exist");
            }
        }
        public void addGroupUsersToExpense(Long groupId, Long expenseId){
            if(expenseRepository.contains(expenseId)){
                expenseRepository.getById(expenseId).getExpenseMembers()
                        .addAll(groupRepository.getById(groupId).getGroupMembers());
            }
        }

}
