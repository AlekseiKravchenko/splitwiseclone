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
        public Expense createExpense(String description, BigDecimal amountOfExpense, Long userPaidById,
                                     LocalDateTime expenseDayTime) {
            Expense expense = new EqualExpense(description,amountOfExpense,userPaidById,
                    expenseDayTime, IdGenerator.generateExpenseId());
            ExpenseRepository.expenseMap.putIfAbsent(expense.getExpenseId(),expense);
            return expense;
        }
        public Expense createExpense(String description, BigDecimal amountOfExpense,
                                     Long userPaidById,LocalDateTime expenseDayTime,Map<Long,BigDecimal> percentValues) {
        Expense expense = new PercentExpense(description,amountOfExpense,userPaidById,
                expenseDayTime, IdGenerator.generateExpenseId(),percentValues);
        ExpenseRepository.expenseMap.putIfAbsent(expense.getExpenseId(),expense);
        return expense;
        }
        public void addUserToExpense(Long userId, Long expenseId) {
            if(ExpenseRepository.expenseMap.containsKey(expenseId)) {
                ExpenseRepository.expenseMap.get(expenseId).addMember(userId);
            } else {
                System.out.println("This expense does not exist");
            }
        }
        public void addGroupUsersToExpense(Long groupId, Long expenseId){
            if(ExpenseRepository.expenseMap.containsKey(expenseId)){
                ExpenseRepository.expenseMap.get(expenseId).getExpenseMembers()
                        .addAll(GroupRepository.groupMap.get(groupId).getGroupMembers());
            }
        }
}
