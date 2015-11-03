package com.example.shoab.weatherapp.data;

import org.json.JSONObject;

/**
 * Created by Shoab on 10/28/2015.
 */
public class Units implements JSONPopulator {
    private String temperature;

    public String getTemperature() {
        return temperature;
    }

    @Override
    public void populate(JSONObject data) {
        temperature = data.optString("temperature");
    }
}
