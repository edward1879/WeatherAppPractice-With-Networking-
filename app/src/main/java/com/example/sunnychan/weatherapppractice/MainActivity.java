package com.example.sunnychan.weatherapppractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView weatherListView;
    private ForecastAdapter forecastAdapter;
    private ArrayList<Weather> weatherListData;
    private RequestQueue requestQueue;
    final String baseURL = "http://api.openweathermap.org/data/2.5/forecast/daily?";
    final String API = "58bf3c983d89485e90d1a287014d0a08";
    final String location = "HongKong,LaiKing";
    final String unit = "metric";
    final String cnt = "16";
    final String requestURL = baseURL+"mode=json"+"&"+"q="+location+"&"+"units="+unit+"&"+"cnt="+cnt+"&"+"appid="+API;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        weatherListData = new ArrayList<>();

        requestQueue = Volley.newRequestQueue(this);
        Log.d("sunny", requestURL);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, requestURL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("sunny", response.toString());
                try {
                    JSONArray weatherListJSONArray = response.getJSONArray("list");
                    Log.d("sunny", weatherListJSONArray.toString());
                    Log.d("sunny", weatherListJSONArray.length()+"");
                    for (int i = 0;i<weatherListJSONArray.length();i++){
                        JSONObject jsonObject = weatherListJSONArray.getJSONObject(i);
                        String time = Utils.toReadableDateString(jsonObject.getString("dt"));
//                        String low = Integer.parseInt(jsonObject.getJSONObject("temp").getString("min"))+"";
//                        String high = Integer.parseInt(jsonObject.getJSONObject("temp").getString("max"))+"";
                        int low = jsonObject.getJSONObject("temp").getInt("min");
                        int high = jsonObject.getJSONObject("temp").getInt("max");

                        String description = jsonObject.getJSONArray("weather").getJSONObject(0).getString("main");
                        Weather weather = new Weather(description,time,low+"",high+"");
                        weatherListData.add(weather);

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("sunny", error.toString());
            }
        });

        requestQueue.add(jsonObjectRequest);


        // Construct the data source
//        weatherListData = Weather.generateSampleData();
        weatherListView = (ListView) findViewById(R.id.list_day);

        // Create the adapter to convert the array to views
        forecastAdapter = new ForecastAdapter(weatherListData,this);
        // Attach the adapter to a ListView
        weatherListView.setAdapter(forecastAdapter);

    }
}
