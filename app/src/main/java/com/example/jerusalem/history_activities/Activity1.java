package com.example.jerusalem.history_activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jerusalem.R;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.squareup.picasso.Picasso;

import java.util.Iterator;

public class Activity1 extends AppCompatActivity {
    FirebaseFirestore firebaseFirestore;
    TextView txt1, img_title1;
    ImageView img1;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        txt1 = findViewById(R.id.txt1);
        img_title1 = findViewById(R.id.img_title1);
        img1 = findViewById(R.id.img1);
        progressBar = findViewById(R.id.progressBar);

        firebaseFirestore = FirebaseFirestore.getInstance();
        firebaseFirestore.collection("History")
                .get()
                .addOnSuccessListener(command -> {
                    Iterator<QueryDocumentSnapshot> iterator = command.iterator();
                    while (iterator.hasNext()) {
                        QueryDocumentSnapshot queryDocumentSnapshot = iterator.next();

                        txt1.setText(queryDocumentSnapshot.getString("txt1"));
                        img_title1.setText(queryDocumentSnapshot.getString("img_title1"));
                        Picasso.get().load(queryDocumentSnapshot.getString("img1")).fit().centerCrop().placeholder(R.mipmap.ic_launcher).into(img1);
                        progressBar.setVisibility(View.INVISIBLE);
                    }
                })
                .addOnFailureListener(command -> {
                    Toast.makeText(this, command.getMessage(), Toast.LENGTH_SHORT).show();
                });

    }
}