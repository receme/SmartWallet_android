package com.rcmapps.smartwallet.presenters;

import com.rcmapps.smartwallet.db.Budget;
import com.rcmapps.smartwallet.db.Expense;
import com.rcmapps.smartwallet.interfaces.IDbmanager;
import com.rcmapps.smartwallet.interfaces.IMainactivity;
import com.rcmapps.smartwallet.utils.DateUtilMethods;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by receme on 3/10/16.
 */
public class MainPresenter {

    private IMainactivity view;
    private IDbmanager dbManager;
    private List<Expense> expenses;

    public MainPresenter(IMainactivity _view, IDbmanager _dbmanager) {
        this.view = _view;
        this.dbManager = _dbmanager;
    }

    public void init() {
        this.expenses  = dbManager.getExpenseHistory();

        if(expenses.isEmpty()){
            expenses = new ArrayList<>();
        }

        view.loadTotalAmount(getTotalAmount());
        view.loadHistory(expenses);

    }

    public int getTotalAmount() {
        List<Budget> entries = dbManager.getBudgetEntries();
        int total = 0;
        if (entries != null) {
            for (Budget budget : entries) {
                int amount = budget.getTotal_amount();
                total += amount;
            }
        }

        return total;
    }

    public void updateTotalAmount(int expense){
        dbManager.updateBudget(new Budget(expense * -1,DateUtilMethods.getCurrentDate(),DateUtilMethods.getCurrentMonthName()));
    }

    public void expenseValidation(String amount, String reason) {

        if (amount.length() == 0) {
            view.showAmountErrorMessage("Expense ammount should not be empty.");
            return;
        }

        int amountVal = Integer.parseInt(amount);

        if (amountVal <= 0) {
            view.showAmountErrorMessage("Expense ammount should be a value greater than zero.");
            return;
        }

        if (reason == null || reason.length() == 0) {
            view.showReasonErrorMessage("There should be a reason for expense");
            return;
        }

        view.addExpense(amountVal, reason);
    }

    public void addBudget(int amount) {
        //here access db method to increase budget;
        long response = dbManager.updateBudget(new Budget(amount, DateUtilMethods.getCurrentDate(), DateUtilMethods.getCurrentMonthName()));

        if(response == -1){
            view.onBudgetAddFailure();
        }
        else{
            view.onBudgetAddSuccess();
            view.loadTotalAmount(getTotalAmount());
        }

    }

    public void addExpense(int amount,String reason){
        Expense expense = new Expense(amount, reason, DateUtilMethods.getCurrentDate());
        long response = dbManager.addExpense(expense);

        if(response == -1){
            view.onExpenseAddFailure();
        }
        else{
            view.onExpenseAddSuccess();
            expenses.add(expense);

            updateTotalAmount(amount);
            view.loadTotalAmount(getTotalAmount());

            view.refreshHistoryList(expenses);
            view.clearExpenseEntryFields();
        }

    }

    public List<Expense> getExpenses(){
        if(expenses!=null){
            return expenses;
        }
        else{
            return new ArrayList<Expense>();
        }
    }


}
