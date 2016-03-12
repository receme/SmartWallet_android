package com.rcmapps.smartwallet.presenters;

import com.rcmapps.smartwallet.db.Budget;
import com.rcmapps.smartwallet.interfaces.IDbmanager;
import com.rcmapps.smartwallet.interfaces.IMainactivity;

import java.util.List;

/**
 * Created by receme on 3/10/16.
 */
public class MainPresenter {
    private IMainactivity view;
    private IDbmanager dbManager;
    public MainPresenter(IMainactivity _view,IDbmanager _dbmanager) {
        this.view = _view;
        this.dbManager = _dbmanager;
    }

    public void init(){

        view.loadTotalAmount(getTotalAmount());
        view.loadHistory(dbManager.getExpenseHistory());
    }

    public int getTotalAmount(){
        List<Budget> entries = dbManager.getBudgetEntries();
        int total = 0;
        for (Budget budget: entries) {
            int amount = budget.getTotal_amount();
            total+=amount;
        }

        return total;
    }
}
