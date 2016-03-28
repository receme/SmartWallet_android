package com.rcmapps.smartwallet.interfaces;

/**
 * Created by receme on 3/29/16.
 */
public interface IAddBudgetFragment {
    void OnValidationSuccess(int amount);
    void showAmountErrorMessage(String message);
}
