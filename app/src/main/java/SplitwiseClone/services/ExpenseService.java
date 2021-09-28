package SplitwiseClone.services;


import SplitwiseClone.entity.*;
import SplitwiseClone.repository.ExpenseRepository;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
public class ExpenseService {
        public Expense createExpense(String description, BigDecimal amountOfExpense,
                                     ExpenseSplitType splitType, User paidBy,
                                     LocalDateTime expenseDayTime) {
            Expense expense = new Expense(description,amountOfExpense,splitType,paidBy,expenseDayTime);
            ExpenseRepository.expenseMap.putIfAbsent(expense.getId(),expense);
            return expense;
        }
}
