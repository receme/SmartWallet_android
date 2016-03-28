package com.rcmapps.smartwallet.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.rcmapps.smartwallet.R;
import com.rcmapps.smartwallet.interfaces.IAddBudgetFragment;
import com.rcmapps.smartwallet.presenters.AddBudgetFragmentPresenter;
import com.rcmapps.smartwallet.presenters.MainPresenter;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by receme on 3/28/16.
 */
public class AddBudgetFragment extends DialogFragment implements IAddBudgetFragment,View.OnClickListener {

    @Bind(R.id.amountEdtxt)
    EditText amountEdtxt;

    @Bind(R.id.okBtn)
    Button okBtn;

    MainPresenter mainPresenter;
    AddBudgetFragmentPresenter presenter;

    public void setPresenter(MainPresenter _mainPresenter){
        this.mainPresenter = _mainPresenter;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_addbudget, container, false);

        ButterKnife.bind(this, view);

        presenter = new AddBudgetFragmentPresenter(this);

        okBtn.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        if (v == okBtn) {
            presenter.newBudgetValidation(amountEdtxt.getText().toString());
        }
    }

    @Override
    public void OnValidationSuccess(int amount) {
        mainPresenter.addBudget(amount);
        dismiss();
    }

    @Override
    public void showAmountErrorMessage(String message) {
        amountEdtxt.setError(message);
    }
}
