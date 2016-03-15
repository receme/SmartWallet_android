package com.rcmapps.smartwallet.db;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "BUDGET".
 */
public class Budget {

    private Long id;
    private Integer total_amount;
    private java.util.Date last_update;
    private String budget_month;

    public Budget() {
    }

    public Budget(Long id) {
        this.id = id;
    }

    public Budget(Long id, Integer total_amount, java.util.Date last_update, String budget_month) {
        this.id = id;
        this.total_amount = total_amount;
        this.last_update = last_update;
        this.budget_month = budget_month;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(Integer total_amount) {
        this.total_amount = total_amount;
    }

    public java.util.Date getLast_update() {
        return last_update;
    }

    public void setLast_update(java.util.Date last_update) {
        this.last_update = last_update;
    }

    public String getBudget_month() {
        return budget_month;
    }

    public void setBudget_month(String budget_month) {
        this.budget_month = budget_month;
    }

}