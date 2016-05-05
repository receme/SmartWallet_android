package com.rcmapps.smartwallet.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.rcmapps.smartwallet.interfaces.IDbmanager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by receme on 3/12/16.
 */
public class DbManager implements IDbmanager {

    SQLiteDatabase db;
    ExpenseDao expenseDao;
    BudgetDao budgetDao;

    private static DbManager instance;

    public static DbManager getInstance(Context context){
        if(instance == null){
            instance = new DbManager(context);
        }
        return instance;
    }

    private DbManager(Context context) {

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context, DbConstants.DB_NAME,null);
        db = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        DaoSession daoSession = daoMaster.newSession();
        expenseDao = daoSession.getExpenseDao();
        budgetDao = daoSession.getBudgetDao();

    }

    @Override
    public long increaseBudget(Budget budget) {
        return budgetDao.insert(budget);
    }

    @Override
    public long addExpense(Expense expense) {
        return expenseDao.insert(expense);
    }

    @Override
    public void updateExpense(Expense expense) {
         expenseDao.update(expense);
    }

    @Override
    public void deleteExpense(Expense expense) {
         expenseDao.delete(expense);
    }

    @Override
    public List<Expense> getExpenseHistory() {
        List<Expense> expenses = expenseDao.loadAll();
        if(expenses==null){
            expenses = new ArrayList<>();
        }
        return expenses;
    }

    @Override
    public List<Budget> getBudgetEntries() {
        List<Budget> budgets =  budgetDao.loadAll();

        if(budgets == null){
            budgets = new ArrayList<>();
        }

        return budgets;
    }
}
