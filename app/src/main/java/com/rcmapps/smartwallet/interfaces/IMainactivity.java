package com.rcmapps.smartwallet.interfaces;

import com.rcmapps.smartwallet.db.Expense;

import java.util.List;

/**
 * Created by receme on 3/10/16.
 */
public interface IMainactivity {

    void loadTotalAmount(int amount);

    void loadHistory(List<Expense> expenses);

    void showAddAmountDialog();

    void addAmount(int amount);

    void addExpense(int amount, String reason);

    void showAmountErrorMessage(String message);

    void showReasonErrorMessage(String message);


    void OnBudgetAddSuccess(String message);

    void OnBudgetAddFailure(String message);

    void OnExpenseAddSuccess(String message);

    void OnExpenseAddFailure(String message);


}
