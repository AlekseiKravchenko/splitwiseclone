package SplitwiseClone.services;

import SplitwiseClone.model.ExpenseModel;

public class ExpenseSplitFactory {
    ExpenseSplitter expenseSplit;
    public ExpenseSplitter getSplit(ExpenseModel expenseModel) {

        switch (expenseModel.getSplitType()) {

            case EQUAL:
                 expenseSplit = new EqualSplit();
                 break;
            case PERCENT:
                 expenseSplit = new PercentSplit();
                 break;
            default:
                System.out.println("Incorrect split type");
                break;
        }
        return expenseSplit;
    }
}
