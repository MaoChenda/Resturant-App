package com.example.smile.fastfoodapp;

import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap pizzaMap;
    private MapView mapView;
    private final double pizzaLat = 11.569028;
    private final double pizzaLng = 104.890610;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        mapView = (MapView)findViewById(R.id.map);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onStart() {
        super.onStart();

        mapView.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();

        mapView.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        mapView.onDestroy();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        pizzaMap = googleMap;

        LatLng pizzaLatLng = new LatLng(pizzaLat, pizzaLng);
        CameraUpdate pizzaCameraUpdate = CameraUpdateFactory.newLatLngZoom(pizzaLatLng, 15);
        //pizzaMap.animateCamera(pizzaCameraUpdate);

        // Add marker
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.title("The Pizza Company");
        markerOptions.position(pizzaLatLng);
        pizzaMap.addMarker(markerOptions);

    }
}
