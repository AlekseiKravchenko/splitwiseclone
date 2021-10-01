package SplitwiseClone.services;


import SplitwiseClone.entity.*;
import SplitwiseClone.repository.*;
import SplitwiseClone.utils.IdGenerator;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
public class ExpenseService {
        public Expense createExpense(String description, BigDecimal amountOfExpense,
                                     ExpenseSplitType splitType, User paidBy,
                                     LocalDateTime expenseDayTime) {
            Expense expense = new Expense(description,amountOfExpense,splitType,paidBy,
                    expenseDayTime, IdGenerator.generateExpenseId());
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
