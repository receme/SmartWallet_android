package com.rcmapps.greendaogenerator;


import java.io.IOException;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class Main {

    public static void main(String[] args) throws Exception {
        Schema schema = new Schema(1,"com.rcmapps.smartwallet.db");

        Entity expenseEntity = schema.addEntity("Expense");
        expenseEntity.addIdProperty();
        expenseEntity.addIntProperty("amount");
        expenseEntity.addStringProperty("reason");
        expenseEntity.addDateProperty("date");

        Entity budgetEntity = schema.addEntity("Budget");
        budgetEntity.addIdProperty();
        budgetEntity.addIntProperty("total_amount");
        budgetEntity.addDateProperty("last_update");
        budgetEntity.addStringProperty("budget_month");

        DaoGenerator generator = new DaoGenerator();
        generator.generateAll(schema,"app/src/main/java/");

    }
}
