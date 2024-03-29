package com.example.sunnychan.weatherapppractice;

import java.util.ArrayList;

/**
 * Created by SunnyChan on 7/10/2016.
 */

public class Weather {
    private String weatherDescription;
    private String date;
    private String low;
    private String high;
    private int weatherIcon;

    public Weather() {
    }

    public Weather(String weatherDescription, String date, String low, String high) {
        this.weatherDescription = weatherDescription;
        this.date = date;
        this.low = low;
        this.high = high;
        setWeatherIcon();
    }

    private void setWeatherIcon(){
        switch (weatherDescription){
            case "Clear":
                weatherIcon = R.drawable.sunny;
                break;
            case "Rain":
                weatherIcon = R.drawable.rainy;
                break;
            case "Clouds":
                weatherIcon = R.drawable.cloudy;
                break;
        }
    }

    public int getWeatherIcon() {
        return weatherIcon;
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

    //used for generating sample weather dataset
    public static ArrayList<Weather> generateSampleData() {
        ArrayList<Weather> weatherArrayList = new ArrayList<>();

        for (int i = 1; i < 20; i++) {
            Weather weather = new Weather("Sunny", i + " Oct", "25", "27");
            weatherArrayList.add(weather);
        }


        return weatherArrayList;
    }
}
