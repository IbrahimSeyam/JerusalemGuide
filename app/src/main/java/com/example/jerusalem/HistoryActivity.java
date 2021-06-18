package com.example.jerusalem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.jerusalem.history_activities.Activity1;
import com.example.jerusalem.history_activities.Activity2;
import com.example.jerusalem.history_activities.Activity3;
import com.example.jerusalem.history_activities.Activity4;
import com.example.jerusalem.history_activities.Activity5;
import com.example.jerusalem.history_activities.Activity6;
import com.example.jerusalem.history_activities.Activity7;
import com.example.jerusalem.history_activities.Activity8;
import com.example.jerusalem.history_activities.Activity9;

public class HistoryActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);


        findViewById(R.id.btn1).setOnClickListener(this);
        findViewById(R.id.btn2).setOnClickListener(this);
        findViewById(R.id.btn3).setOnClickListener(this);
        findViewById(R.id.btn4).setOnClickListener(this);
        findViewById(R.id.btn5).setOnClickListener(this);
        findViewById(R.id.btn6).setOnClickListener(this);
        findViewById(R.id.btn7).setOnClickListener(this);
        findViewById(R.id.btn8).setOnClickListener(this);
        findViewById(R.id.btn9).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn1) {
            startActivity(new Intent(this, Activity1.class));
        } else if (v.getId() == R.id.btn2) {
            startActivity(new Intent(this, Activity2.class));
        } else if (v.getId() == R.id.btn3) {
            startActivity(new Intent(this, Activity3.class));
        } else if (v.getId() == R.id.btn4) {
            startActivity(new Intent(this, Activity4.class));

        } else if (v.getId() == R.id.btn5) {
            startActivity(new Intent(this, Activity5.class));
        } else if (v.getId() == R.id.btn6) {
            startActivity(new Intent(this, Activity6.class));
        } else if (v.getId() == R.id.btn7) {
            startActivity(new Intent(this, Activity7.class));
        } else if (v.getId() == R.id.btn8) {
            startActivity(new Intent(this, Activity8.class));
        } else if (v.getId() == R.id.btn9) {
            startActivity(new Intent(this, Activity9.class));
        }
    }
}