package com.rcmapps.greendaogenerator;


import java.io.IOException;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class Main {

    public static void main(String[] args) throws Exception {
        Schema schema = new Schema(1,"com.rcmapps.smartwallet.db");

        Entity entity = schema.addEntity("Expense");
        entity.addIdProperty();
        entity.addIntProperty("amount");
        entity.addStringProperty("reason");
        entity.addDateProperty("date");

        DaoGenerator generator = new DaoGenerator();
        generator.generateAll(schema,"app/src/main/java/");

    }
}
