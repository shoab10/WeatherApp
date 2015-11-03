package com.example.shoab.weatherapp.services;

import com.example.shoab.weatherapp.data.Channel;

/**
 * Created by Shoab on 10/28/2015.
 */
public interface WeatherServiceCallback {
    void serviceSuccess(Channel channel);
    void serviceFail(Exception exception);
}
