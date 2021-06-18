package com.example.jerusalem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;

import com.example.jerusalem.aqsa_activities.BawaikActivity;
import com.example.jerusalem.aqsa_activities.DomesActivity;
import com.example.jerusalem.aqsa_activities.GatesActivity;
import com.example.jerusalem.aqsa_activities.MaathenActivity;
import com.example.jerusalem.aqsa_activities.MasajedActivity;

public class AqsaActivity extends AppCompatActivity {
    CardView masajedCard, maathenCard, gatesCard, bawaikCard, domesCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aqsa);

        initViews();

        masajedCard.setOnClickListener(v -> {
            startActivity(new Intent(this, MasajedActivity.class));
        });
        maathenCard.setOnClickListener(v -> {
            startActivity(new Intent(this, MaathenActivity.class));
        });
        gatesCard.setOnClickListener(v -> {
            startActivity(new Intent(this, GatesActivity.class));
        });
        bawaikCard.setOnClickListener(v -> {
            startActivity(new Intent(this, BawaikActivity.class));
        });
        domesCard.setOnClickListener(v -> {
            startActivity(new Intent(this, DomesActivity.class));
        });


    }

    private void initViews(){
        masajedCard = findViewById(R.id.masajedCard);
        maathenCard = findViewById(R.id.maathenCard);
        gatesCard = findViewById(R.id.gatesCard);
        bawaikCard = findViewById(R.id.bawaikCard);
        domesCard = findViewById(R.id.domesCard);
    }
}