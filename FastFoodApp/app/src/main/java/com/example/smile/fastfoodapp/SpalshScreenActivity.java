package com.example.smile.fastfoodapp;

import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SpalshScreenActivity extends AppCompatActivity {

    private TextView shopName;
    private TextView shopDes;
//    private ListView lvLocation;
//    private LocationAdapter adapter;
//    private List<Location> mLocationList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        shopName = (TextView)findViewById(R.id.shop_name);
        shopDes = (TextView)findViewById(R.id.shop_des);

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.transition);
        shopName.startAnimation(animation);
        shopDes.startAnimation(animation);

        final Intent intent  = new Intent(this, MainActivity.class );

        Thread timer = new Thread(){
            public void run(){
                try {
                    sleep(1500);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                finally {
                    startActivity(intent);
                    finish();
                }
            }
        };
        timer.start();
    }
}
