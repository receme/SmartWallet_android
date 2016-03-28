package com.rcmapps.smartwallet.presenters;

import com.rcmapps.smartwallet.interfaces.IAddBudgetFragment;

/**
 * Created by receme on 3/29/16.
 */
public class AddBudgetFragmentPresenter {

    IAddBudgetFragment view;
    public AddBudgetFragmentPresenter(IAddBudgetFragment _view){
        this.view = _view;
    }

    public void newBudgetValidation(String amount){

        if(amount==null || amount.length() == 0){
            view.showAmountErrorMessage("Budget amount should not be null");
            return;
        }

        int amountVal = Integer.parseInt(amount);

        if(amountVal==0){
            view.showAmountErrorMessage("Budget amount should be a value greater than zero");
            return;
        }

        view.OnValidationSuccess(amountVal);
    }
}
