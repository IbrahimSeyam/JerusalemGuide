package com.example.jerusalem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.jerusalem.fragments.AlqiblyFragment;
import com.example.jerusalem.fragments.AlqeyamaFragment;
import com.example.jerusalem.fragments.DomeFragment;
import com.example.jerusalem.adapters.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class CameraActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
//    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
//        toolbar = findViewById(R.id.toolbar);

//        setSupportActionBar(toolbar);


        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new AlqiblyFragment(), "1");
        adapter.addFragment(new DomeFragment(), "2");
        adapter.addFragment(new AlqeyamaFragment(), "3");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }
}