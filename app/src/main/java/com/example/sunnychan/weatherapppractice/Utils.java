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
//        DateFormat format = new SimpleDateFormat("MMddyyHHmmss");
        DateFormat format = new SimpleDateFormat("dd-MM");
        Date date = null;

        Timestamp timestamp = new Timestamp(Long.parseLong(timeStamp)*1000L);
        date = new Date();
        date = timestamp;
        Log.d("sunny", "timestamp.getTime(): "+ date.toString());
        String readableDate = format.format(date);

//        date = format.parse(timeStamp);

        return readableDate;
    }
}
