package com.rcmapps.smartwallet.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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

    private LinearLayoutManager mLinearLayoutManager;

    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        addAmountBtn.setOnClickListener(this);
        addExpenseBtn.setOnClickListener(this);

        presenter = new MainPresenter(this, ApplicationObject.dbManager);
        presenter.init();


    }

    @Override
    public void loadTotalAmount(int amount) {
        totalAmountTv.setText(Integer.toString(amount));
    }

    @Override
    public void loadHistory(List<Expense> expenses) {

        ExpenseHistoryListApapter adapter = new ExpenseHistoryListApapter(this, expenses);
        historyItemList.setHasFixedSize(true);
        mLinearLayoutManager = new LinearLayoutManager(this);
        mLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        historyItemList.setLayoutManager(mLinearLayoutManager);

        historyItemList.setAdapter(adapter);
    }

    @Override
    public void showAddAmountDialog() {

        FragmentManager fragmentManager = getSupportFragmentManager();
        AddBudgetFragment addBudgetFragment = new AddBudgetFragment();
        addBudgetFragment.show(fragmentManager,"add_budget_dialog");
    }

    @Override
    public void addAmount(int amount) {

    }

    @Override
    public void addExpense(int amount, String reason) {

    }

    @Override
    public void showAmountErrorMessage(String message) {
        amountEdtxt.setError(message);
    }

    @Override
    public void showReasonErrorMessage(String message) {
        reasonEdtxt.setError(message);
    }

    @Override
    public void onClick(View v) {
        if (v == addAmountBtn) {
            showAddAmountDialog();
        } else if (v == addExpenseBtn) {

            presenter.expenseValidation(amountEdtxt.getText().toString()
                    ,reasonEdtxt.getText().toString());
        }
    }
}
