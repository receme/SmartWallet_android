package com.rcmapps.smartwallet.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by receme on 5/6/16.
 */
public class DateUtilMethods {

    public static Date getCurrentDate(){
        Calendar cal = Calendar.getInstance();
        //SimpleDateFormat sf = new SimpleDateFormat("MMM dd,YYYY HH:mm a");
        return cal.getTime();
    }

    public static String getCurrentMonthName(){
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sf = new SimpleDateFormat("MMM");
        return sf.format(cal.getTime());
    }
}
