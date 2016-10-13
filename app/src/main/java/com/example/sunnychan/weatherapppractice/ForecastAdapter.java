package com.example.sunnychan.weatherapppractice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by SunnyChan on 7/10/2016.
 */

public class ForecastAdapter extends BaseAdapter {
    private ArrayList<Weather> datalist;
    private Context context;

    public ForecastAdapter(ArrayList<Weather> datalist, Context context) {
        this.datalist = datalist;
        this.context = context;
    }

    @Override
    public int getCount() {
        return datalist.size();
    }

    @Override
    public Object getItem(int i) {
        return datalist.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        Weather weather = (Weather) getItem(i);

        //check if the the convertView is created
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.cell_forecast,viewGroup,false);
        }

        TextView tvWeatherDesciption = (TextView) convertView.findViewById(R.id.tv_weatherDescription);
        TextView tvLow = (TextView) convertView.findViewById(R.id.tv_low);
        TextView tvHigh = (TextView) convertView.findViewById(R.id.tv_high);
        TextView tvDate = (TextView) convertView.findViewById(R.id.tv_date);

        tvWeatherDesciption.setText(weather.getWeatherDescription());
        tvHigh.setText(weather.getHigh());
        tvLow.setText(weather.getLow());
        tvDate.setText(weather.getDate());


        return convertView;
    }

}
