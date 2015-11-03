package com.example.shoab.weatherapp.services;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.location.LocationServices;

/**
 * Created by Shoab on 10/30/2015.
 */
public class LocationProviderService implements
        ConnectionCallbacks, OnConnectionFailedListener {
    public static final String TAG = LocationProviderService.class.getSimpleName();

    private GoogleApiClient mGoogleApiClient;
    private Location mLastLocation;
    Context mcontext;

    public LocationProviderService(Context context) {
        mcontext = context;
        mGoogleApiClient = new GoogleApiClient.Builder(context)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
        mGoogleApiClient.connect();
    }

    public Location getLocation() {
        return mLastLocation;
    }

    @Override
    public void onConnected(Bundle bundle) {
        Log.i(TAG, "Now Connected");
        mLastLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);

        if (mLastLocation != null) {
            String locationtext = String.valueOf((mLastLocation.getLatitude()))+","+String.valueOf((mLastLocation.getLongitude()));
            Toast.makeText(mcontext, locationtext, Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(mcontext, "No Location Detected", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onConnectionSuspended(int i) {
        Log.i("MainActivity", "Connection Suspended");
        mGoogleApiClient.connect();
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        Log.i("MainActivity", "Connection failed: ConnectionResult.getErrorCode() = "+ connectionResult.getErrorMessage());
    }
}
