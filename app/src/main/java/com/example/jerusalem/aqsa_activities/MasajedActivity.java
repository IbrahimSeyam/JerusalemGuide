package com.example.jerusalem.aqsa_activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.jerusalem.R;
import com.example.jerusalem.masajed_activities.AlqiblyActivity;
import com.example.jerusalem.masajed_activities.OldActivity;

public class MasajedActivity extends AppCompatActivity {
    Button alqibly_btn, old_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masajed);

        initViews();

        alqibly_btn.setOnClickListener(v -> {
            startActivity(new Intent(this, AlqiblyActivity.class));
        });

        old_btn.setOnClickListener(v -> {
            startActivity(new Intent(this, OldActivity.class));
        });
    }

    private void initViews() {
        alqibly_btn = findViewById(R.id.alqibly_btn);
        old_btn = findViewById(R.id.old_btn);
    }
}