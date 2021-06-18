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

public class Activity2 extends AppCompatActivity {
    FirebaseFirestore firebaseFirestore;
    TextView txt2, img_title2;
    ImageView img2;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        txt2 = findViewById(R.id.txt2);
        img_title2 = findViewById(R.id.img_title2);
        img2 = findViewById(R.id.img2);
        progressBar = findViewById(R.id.progressBar);

        firebaseFirestore = FirebaseFirestore.getInstance();
        firebaseFirestore.collection("History")
                .get()
                .addOnSuccessListener(command -> {
                    Iterator<QueryDocumentSnapshot> iterator = command.iterator();
                    while (iterator.hasNext()) {
                        QueryDocumentSnapshot queryDocumentSnapshot = iterator.next();

                        txt2.setText(queryDocumentSnapshot.getString("txt2"));
                        img_title2.setText(queryDocumentSnapshot.getString("img_title2"));
                        Picasso.get().load(queryDocumentSnapshot.getString("img2")).fit().centerCrop().placeholder(R.mipmap.ic_launcher).into(img2);
                        progressBar.setVisibility(View.INVISIBLE);
                    }
                })
                .addOnFailureListener(command -> {
                    Toast.makeText(this, command.getMessage(), Toast.LENGTH_SHORT).show();
                });
    }
}