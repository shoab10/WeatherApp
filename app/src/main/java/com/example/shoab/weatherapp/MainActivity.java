package com.example.shoab.weatherapp;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.example.shoab.weatherapp.services.LocationProviderService;
import com.google.android.gms.common.api.GoogleApiClient;



public class MainActivity extends AppCompatActivity{
    public static final String TAG = MainActivity.class.getSimpleName();
    private GoogleApiClient mGoogleApiClient;
    private Location mLastLocation;
    private String locationtext;
    private LocationProviderService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        service = new LocationProviderService(this);
    }

    public void showWeather(View view) {
        Intent intent = new Intent(this, WeatherActivity.class);
        EditText locationEditText = (EditText) findViewById(R.id.locationEditText);
        String location = locationEditText.getText().toString();
        intent.putExtra("com.example.shoab.weatherapp.LOCATION", location);
        startActivity(intent);
    }
}