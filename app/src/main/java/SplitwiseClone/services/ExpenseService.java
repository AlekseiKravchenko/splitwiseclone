package SplitwiseClone.services;

import SplitwiseClone.entity.Expense.EqualExpense;
import SplitwiseClone.entity.Expense.Expense;
import SplitwiseClone.entity.Expense.PercentExpense;
import SplitwiseClone.repository.*;
import SplitwiseClone.utils.IdGenerator;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@NoArgsConstructor
public class ExpenseService {
    ExpenseRepository er = new ExpenseRepository();
    UserRepository ur = new UserRepository();
    GroupRepository gr = new GroupRepository();
        public Expense createExpense(String description, BigDecimal amountOfExpense, Long userPaidById,
                                     LocalDateTime expenseDayTime) {
            Expense expense = new EqualExpense(description,amountOfExpense,userPaidById,
                    expenseDayTime, IdGenerator.generateExpenseId());
            er.addToRepository(expense.getExpenseId(),expense);
            return expense;
        }
        public Expense createExpense(String description, BigDecimal amountOfExpense,
                                     Long userPaidById,LocalDateTime expenseDayTime,Map<Long,BigDecimal> percentValues) {
        Expense expense = new PercentExpense(description,amountOfExpense,userPaidById,
                expenseDayTime, IdGenerator.generateExpenseId(),percentValues);
            er.addToRepository(expense.getExpenseId(),expense);
        return expense;
        }
        public void addUserToExpense(Long userId, Long expenseId) {
            if(er.contains(expenseId)) {
                er.getFromRepositoryById(expenseId).getExpenseMembers().add(ur.getFromRepositoryById(userId));
            } else {
                System.out.println("This expense does not exist");
            }
        }
        public void addGroupUsersToExpense(Long groupId, Long expenseId){
            if(er.contains(expenseId)){
                er.getFromRepositoryById(expenseId).getExpenseMembers()
                        .addAll(gr.getFromRepositoryById(groupId).getGroupMembers());
            }
        }
}
