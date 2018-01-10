package com.example.smile.fastfoodapp;

import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import com.example.smile.fastfoodapp.fragment.CartFragment;
import com.example.smile.fastfoodapp.fragment.HomeFragment;
import com.example.smile.fastfoodapp.fragment.LocationFragment;
import com.example.smile.fastfoodapp.fragment.MenuFragment;
import com.example.smile.fastfoodapp.fragment.SettingFragment;

public class MainActivity extends AppCompatActivity  implements  BottomNavigationView.OnNavigationItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        displaySelectedScreen(R.id.ic_home);
    }

    @SuppressWarnings("StatementWithEmptyBody")

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        displaySelectedScreen(item.getItemId());
        return true;
    }

    private void displaySelectedScreen(int itemId){
        Fragment fragment = null;

        switch (itemId) {
            case R.id.ic_home:
                fragment = new HomeFragment();
                break;

            case R.id.ic_menu:
                fragment = new MenuFragment();
                break;

            case R.id.ic_location:
                fragment = new LocationFragment();
                break;

            case R.id.ic_cart:
                fragment = new CartFragment();
                break;

            case R.id.ic_setting:
                fragment = new SettingFragment();
        }
        if (fragment != null){
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.contain_frame, fragment);
            fragmentTransaction.commit();
        }
    }

}
