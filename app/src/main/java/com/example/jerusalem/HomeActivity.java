package com.example.jerusalem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.example.jerusalem.fragments.MainFragment;
import com.example.jerusalem.fragments.MapsFragment;
import com.example.jerusalem.fragments.Photos360Fragment;
import com.example.jerusalem.fragments.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {
    BottomNavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initViews();


//        navigationView.setBackground(null);
//        navigationView.getMenu().getItem(2).setEnabled(false);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new MainFragment())
                .commit();


        navigationView.setOnItemSelectedListener(item -> {
            Fragment fragment = null;
            switch (item.getItemId()) {
                case R.id.nav_location:
                    fragment = new MapsFragment();
                    break;
                case R.id.nav_search:
                    fragment = new SearchFragment();
                    break;
                case R.id.nav_main:
                    fragment = new MainFragment();
                    break;
                case R.id.nav_photos360:
                    fragment = new Photos360Fragment();
            }
//            Bundle bundle = new Bundle();
//            fragment.setArguments(bundle);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        });
    }

    private void initViews() {
        navigationView = findViewById(R.id.bottomNav);

    }
}