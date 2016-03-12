package com.rcmapps.smartwallet.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.rcmapps.smartwallet.R;
import com.rcmapps.smartwallet.interfaces.IMainactivity;
import com.rcmapps.smartwallet.models.Expense;
import com.rcmapps.smartwallet.presenters.MainPresenter;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements IMainactivity{

    @Bind(R.id.totalAmountTv) TextView totalAmountTv;
    @Bind(R.id.addAmountBtn) Button addAmountBtn;
    @Bind(R.id.amountEdtxt) EditText amountEdtxt;
    @Bind(R.id.reasonEdtxt) EditText reasonEdtxt;
    @Bind(R.id.addExpenseBtn) EditText addExpenseBtn;
    @Bind(R.id.historyItemList) RecyclerView historyItemList;

    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        presenter = new MainPresenter(this);
        presenter.init();


    }

    @Override
    public void loadTotalAmount(int amount) {

    }

    @Override
    public void loadHistory(List<Expense> expenses) {

    }

    @Override
    public void AddAmount(int amount) {

    }

    @Override
    public void AddExpense(int amount, String reason) {

    }
}
