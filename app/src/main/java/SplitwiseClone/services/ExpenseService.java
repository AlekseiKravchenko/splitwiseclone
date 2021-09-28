package SplitwiseClone.services;


import SplitwiseClone.entity.*;
import SplitwiseClone.repository.*;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
public class ExpenseService {
        public Expense createExpense(String description, BigDecimal amountOfExpense,
                                     ExpenseSplitType splitType, User paidBy,
                                     LocalDateTime expenseDayTime) {
            Expense expense = new Expense(description,amountOfExpense,splitType,paidBy,expenseDayTime);
            ExpenseRepository.expenseMap.putIfAbsent(expense.getExpenseId(),expense);
            return expense;
        }
        public void addUserToExpense(User user, Long expenseId) {
            if(ExpenseRepository.expenseMap.containsKey(expenseId)) {
                ExpenseRepository.expenseMap.get(expenseId).addMember(user);
            } else {
                System.out.println("This expense does not exist");
            }
        }
        public void addGroupUsersToExpense(Group group, Long expenseId){
            if(ExpenseRepository.expenseMap.containsKey(expenseId)){
                ExpenseRepository.expenseMap.get(expenseId).addGroupMembers(group);
            }
        }
}
