package com.example.sunnychan.weatherapppractice;

import android.util.Log;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by SunnyChan on 14/10/2016.
 */

public class Utils {
    public static String toReadableDateString(String timeStamp) throws ParseException {
        //http://stackoverflow.com/questions/3790954/how-to-get-localized-short-day-in-week-name-mo-tu-we-th
        //EEE can get the Short-name of a day
        DateFormat format = new SimpleDateFormat("dd-MMM (EEE)");

        Timestamp timestamp = new Timestamp(Long.parseLong(timeStamp) * 1000L);
        Date date = timestamp;
        Log.d("sunny", "timestamp.getTime(): " + date.toString());
        String readableDate = format.format(date);

        return readableDate;
    }
}
