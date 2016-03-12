package com.rcmapps.smartwallet.models;

/**
 * Created by receme on 3/12/16.
 */
public class Expense {

    private int amount;
    private String reason;
    private String dateStr;

    public Expense(int amount, String reason, String dateStr) {
        this.amount = amount;
        this.reason = reason;
        this.dateStr = dateStr;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDateStr() {
        return dateStr;
    }

    public void setDateStr(String dateStr) {
        this.dateStr = dateStr;
    }
}
