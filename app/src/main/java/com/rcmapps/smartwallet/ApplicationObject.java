package com.rcmapps.smartwallet;

import android.app.Application;

import com.rcmapps.smartwallet.db.DbManager;

/**
 * Created by receme on 3/13/16.
 */
public class ApplicationObject extends Application {

    public static DbManager dbManager;
    @Override
    public void onCreate() {
        super.onCreate();
        dbManager = DbManager.getInstance(this);
    }
}
