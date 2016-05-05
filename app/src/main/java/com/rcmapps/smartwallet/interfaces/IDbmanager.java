package com.rcmapps.smartwallet.interfaces;

import com.rcmapps.smartwallet.db.Budget;
import com.rcmapps.smartwallet.db.Expense;

import java.util.Date;
import java.util.List;

/**
 * Created by receme on 3/12/16.
 */
public interface IDbmanager {

    long increaseBudget(Budget budget);
    long addExpense(Expense expense);
    void updateExpense(Expense expense);
    void deleteExpense(Expense expense);
    List<Expense> getExpenseHistory();
    List<Budget> getBudgetEntries();
}
