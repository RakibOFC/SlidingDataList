package com.kmm.slidingdatalist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.slider.Slider;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);
        ViewPager viewPager = findViewById(R.id.view_pager);
        FloatingActionButton fab = findViewById(R.id.fab);
        View navDrawer = findViewById(R.id.nav_drawer);
        Slider sliderTextSize = navDrawer.findViewById(R.id.slider_text_size);
        ViewPagerAdapter adapter = new ViewPagerAdapter(10);

        fab.setOnClickListener(this);

        sliderTextSize.addOnChangeListener((slider, value, fromUser) -> {

            if (fromUser) {
                adapter.setTextSizes(value);
            }
        });

        adapter.setTextSizes(14);
        viewPager.setAdapter(adapter);
        viewPager.setRotation(180);
        viewPager.setCurrentItem(4);
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.fab) {
            drawerLayout.openDrawer(GravityCompat.END);
        }
    }
}