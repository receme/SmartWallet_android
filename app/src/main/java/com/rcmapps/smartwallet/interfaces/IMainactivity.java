package com.rcmapps.smartwallet.interfaces;

import com.rcmapps.smartwallet.models.Expense;

import java.util.List;

/**
 * Created by receme on 3/10/16.
 */
public interface IMainactivity {

    void loadTotalAmount(int amount);
    void loadHistory(List<Expense> expenses);
    void AddAmount(int amount);
    void AddExpense(int amount,String reason);


}
