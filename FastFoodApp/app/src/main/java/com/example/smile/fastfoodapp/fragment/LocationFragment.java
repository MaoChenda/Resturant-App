package com.example.smile.fastfoodapp.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.Toolbar;

import com.example.smile.fastfoodapp.LocationAdapter;
import com.example.smile.fastfoodapp.MapActivity;
import com.example.smile.fastfoodapp.R;

public class LocationFragment extends Fragment{

    private RecyclerView locationRecyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    String[] location_branch = {
            "FAST FOOD KAMPUCHEA KROM", "FAST FOOD TOUL KOK", "FAST FOOD SORYA", "FAST FOOD CALMATTE", "FAST FOOD VIMEANTEP",
            "FAST FOOD BEONG KENG KONG", "FAST FOOD RIVER SIDE", "FAST FOOD AEON MALL", "FAST FOOD MONIVONG", "FAST FOOD TAKHMAO"
    };
    String[] location_branch_sub = {
            "Kampuchea krom Blv", "Avenue", "Sorya shoping center", "Near old staduim", "Behind Germany Embassy",
            "Str.150", "River side","Aeon mall", "Monivong Blv, Beong Trar Beak", "Kandal Province"
    };
    String[] location_branch_num = {
            "+855 23 112 221", "+855 23 331 113", "+855 23 223 332", "+855 23 443 334", "+855 23 445 554",
            "+855 23 556 665", "+855 23 667 776","+855 23 778 887", "+855 23 889 998", "+855 23 990 009"
    };

    public LocationFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View fragmentView = inflater.inflate(R.layout.fragment_location, container, false);

        Toolbar toolbar = (Toolbar)getActivity(). findViewById(R.id.toolbar);
       ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

//        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Location");

         setHasOptionsMenu(true);

         // List View Location

        locationRecyclerView = (RecyclerView) fragmentView.findViewById(R.id.location_recycler);
        adapter = new LocationAdapter(location_branch, location_branch_sub, location_branch_num);

        layoutManager = new LinearLayoutManager(getActivity());
        locationRecyclerView.setLayoutManager(layoutManager);
        locationRecyclerView.setHasFixedSize(true);
        locationRecyclerView.setAdapter(adapter);

        return fragmentView;

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_location, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id  = item.getItemId();

        if (id == R.id.action_location){
            Intent intent = new Intent(getActivity(), MapActivity.class);
            this.startActivity(intent);
            //return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
