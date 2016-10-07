package com.example.sunnychan.weatherapppractice;

/**
 * Created by SunnyChan on 7/10/2016.
 */

public class Weather {
    private String weatherDescription;
    private String date;
    private String low;
    private String high;

    public Weather() {
    }

    public Weather(String weatherDescription, String date, String low, String high) {
        this.weatherDescription = weatherDescription;
        this.date = date;
        this.low = low;
        this.high = high;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }

    public void setWeatherDescription(String weatherDescription) {
        this.weatherDescription = weatherDescription;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }
}
