package com.example.smile.fastfoodapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Smile on 11/27/2017.
 */

public class LocationAdapter extends RecyclerView.Adapter<LocationAdapter.LocationViewHolder>{

    String[] location_branch, location_branch_sub, location_branch_num;

    public LocationAdapter(String[] location_branch, String[] location_branch_sub, String[] location_branch_num) {
        this.location_branch = location_branch;
        this.location_branch_sub = location_branch_sub;
        this.location_branch_num = location_branch_num;
    }

    @Override
    public LocationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_location,parent,false);

        LocationViewHolder recyclerViewHolder = new LocationViewHolder(view);
        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(LocationViewHolder holder, int position) {
        holder.txtLocation.setText(location_branch[position]);
        holder.txtLocationSub.setText(location_branch_sub[position]);
        holder.txtLocationNum.setText(location_branch_num[position]);

    }

    @Override
    public int getItemCount() {
        return location_branch.length;
    }

    public static class LocationViewHolder extends RecyclerView.ViewHolder
    {
        TextView txtLocation, txtLocationSub, txtLocationNum;

        public LocationViewHolder(View view){
            super(view);
            txtLocation = (TextView)view.findViewById(R.id.location_branch);
            txtLocationSub = (TextView)view.findViewById(R.id.location_branch_sub);
            txtLocationNum = (TextView)view.findViewById(R.id.location_branch_num);
        }
    }
}
