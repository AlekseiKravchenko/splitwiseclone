package SplitwiseClone.services;

import SplitwiseClone.entity.*;
import SplitwiseClone.repository.ExpenseRepository;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;



public class ExpenseCalculateService {
    public void calculateEqualExpense(Long expenseId) {
        Map<User,BigDecimal> amountsOwed = new HashMap<>();
        Map<User,BigDecimal> amountsPaid = new HashMap<>();
        BigDecimal count = new BigDecimal(ExpenseRepository.expenseMap.get(expenseId).getExpenseMembers().size());
        for (User expenseMember : ExpenseRepository.expenseMap.get(expenseId).getExpenseMembers()) {
            if(!ExpenseRepository.expenseMap.get(expenseId).getPaidBy().equals(expenseMember)) {
                BigDecimal amountOwes = ExpenseRepository.expenseMap.get(expenseId).getAmountOfExpense()
                        .divide(count,2,RoundingMode.UP);
                amountsOwed.put(expenseMember, amountOwes);
            } else {
                BigDecimal amountPaid = ExpenseRepository.expenseMap.get(expenseId).getAmountOfExpense()
                        .divide(count,2,RoundingMode.FLOOR);
                amountsPaid.put(expenseMember, amountPaid);
            }
        }
        ExpenseRepository.expenseMap.get(expenseId).setAmountsOwed(amountsOwed);
        ExpenseRepository.expenseMap.get(expenseId).setAmountsPaid(amountsPaid);
    }
    public void calculatePercentExpense(Long expenseId, Map<Long,BigDecimal> percentValues) {
        Map<User,BigDecimal> amountsOwed = new HashMap<>();
        Map<User,BigDecimal> amountsPaid = new HashMap<>();
        BigDecimal oneHundred = new BigDecimal("100.00");
        for (User expenseMember : ExpenseRepository.expenseMap.get(expenseId).getExpenseMembers()) {
            if(!ExpenseRepository.expenseMap.get(expenseId).getPaidBy().equals(expenseMember)) {
                BigDecimal amountOwes = ExpenseRepository.expenseMap.get(expenseId).getAmountOfExpense()
                        .multiply(percentValues.get(expenseMember.getId())).divide(oneHundred,2,RoundingMode.UP);
                amountsOwed.put(expenseMember,amountOwes);
            } else {
                BigDecimal amountPaid = ExpenseRepository.expenseMap.get(expenseId).getAmountOfExpense()
                        .multiply(percentValues.get(expenseMember.getId())).divide(oneHundred,2,RoundingMode.UP);
                amountsPaid.put(expenseMember, amountPaid);
            }
            ExpenseRepository.expenseMap.get(expenseId).setAmountsOwed(amountsOwed);
            ExpenseRepository.expenseMap.get(expenseId).setAmountsPaid(amountsPaid);
        }
    }

}


