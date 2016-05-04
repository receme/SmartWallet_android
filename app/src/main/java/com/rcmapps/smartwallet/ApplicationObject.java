package com.rcmapps.smartwallet;

import android.app.Application;

import com.rcmapps.smartwallet.db.DbManager;
import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;

/**
 * Created by receme on 3/13/16.
 */
public class ApplicationObject extends Application {

    public static DbManager dbManager;
    @Override
    public void onCreate() {
        super.onCreate();
        Fabric.with(this, new Crashlytics());
        dbManager = DbManager.getInstance(this);
    }
}
