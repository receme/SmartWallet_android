package com.rcmapps.smartwallet.activities;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.crashlytics.android.Crashlytics;
import com.rcmapps.smartwallet.ApplicationObject;
import com.rcmapps.smartwallet.R;
import com.rcmapps.smartwallet.adapters.ExpenseHistoryListApapter;
import com.rcmapps.smartwallet.db.Expense;
import com.rcmapps.smartwallet.fragments.AddBudgetFragment;
import com.rcmapps.smartwallet.interfaces.IMainactivity;
import com.rcmapps.smartwallet.presenters.MainPresenter;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity implements IMainactivity, View.OnClickListener {

    @Bind(R.id.totalAmountTv)
    TextView totalAmountTv;
    @Bind(R.id.addAmountBtn)
    Button addAmountBtn;
    @Bind(R.id.amountEdtxt)
    EditText amountEdtxt;
    @Bind(R.id.reasonEdtxt)
    EditText reasonEdtxt;
    @Bind(R.id.addExpenseBtn)
    Button addExpenseBtn;
    @Bind(R.id.historyItemList)
    RecyclerView historyItemList;

    @Bind(R.id.coordinateLayout)
    CoordinatorLayout coordinatorLayout;

    private LinearLayoutManager mLinearLayoutManager;

    private MainPresenter presenter;

    private Snackbar snackbar;
    private ExpenseHistoryListApapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fabric.with(this, new Crashlytics());
        ButterKnife.bind(this);

        addAmountBtn.setOnClickListener(this);
        addExpenseBtn.setOnClickListener(this);

        presenter = new MainPresenter(this, ApplicationObject.dbManager);
        presenter.init();


        snackbar = Snackbar
                .make(coordinatorLayout, "", Snackbar.LENGTH_SHORT);
        View snackBarview = snackbar.getView();
        snackBarview.setBackgroundColor(Color.parseColor("#3F51B5"));
        TextView textView = (TextView) snackBarview.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(Color.WHITE);

    }

    /*public void forceCrash() {
        throw new RuntimeException("This is a crash");
    }*/


    @Override
    public void loadTotalAmount(int amount) {
        totalAmountTv.setText(Integer.toString(amount));
    }

    @Override
    public void loadHistory(List<Expense> expenses) {

        adapter = new ExpenseHistoryListApapter(this, expenses);
        historyItemList.setHasFixedSize(true);
        mLinearLayoutManager = new LinearLayoutManager(this);
        mLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        historyItemList.setLayoutManager(mLinearLayoutManager);

        historyItemList.setAdapter(adapter);
    }

    @Override
    public void refreshHistoryList(List<Expense> expenses) {

        int position = expenses.size()-1;
        adapter.notifyItemInserted(position);
        adapter.notifyItemRangeChanged(position, expenses.size());
        adapter.notifyDataSetChanged();

        //scroll to updated item
        historyItemList.smoothScrollToPosition(position);
    }

    @Override
    public void showAddAmountDialog() {

        FragmentManager fragmentManager = getSupportFragmentManager();
        AddBudgetFragment addBudgetFragment = new AddBudgetFragment();
        addBudgetFragment.setPresenter(presenter);
        addBudgetFragment.show(fragmentManager, "add_budget_dialog");
    }

    @Override
    public void addAmount(int amount) {

    }

    @Override
    public void addExpense(int amount, String reason) {
        presenter.addExpense(amount,reason);
    }

    @Override
    public void showAmountErrorMessage(String message) {
        amountEdtxt.setError(message);

        snackbar.setText(message);
        snackbar.show();
    }

    @Override
    public void showReasonErrorMessage(String message) {
        reasonEdtxt.setError(message);

        snackbar.setText(message);
        snackbar.show();
    }

    @Override
    public void onBudgetAddSuccess() {
        Toast.makeText(this,getString(R.string.budget_add_success_msg),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBudgetAddFailure() {
        Toast.makeText(this,getString(R.string.budget_add_failure_msg),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onExpenseAddSuccess() {
        Toast.makeText(this,getString(R.string.expense_add_failure_msg),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onExpenseAddFailure() {
        Toast.makeText(this,getString(R.string.expense_add_failure_msg),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void clearExpenseEntryFields() {
        amountEdtxt.setText("");
        reasonEdtxt.setText("");
    }

    @Override
    public void onClick(View v) {
        if (v.equals(addAmountBtn)) {
            showAddAmountDialog();
        } else if (v.equals(addExpenseBtn)) {

            presenter.expenseValidation(amountEdtxt.getText().toString()
                    , reasonEdtxt.getText().toString());
        }
    }
}
