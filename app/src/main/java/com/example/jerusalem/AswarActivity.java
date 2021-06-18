package com.example.jerusalem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.jerusalem.adapters.ImagesAdapter;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AswarActivity extends AppCompatActivity {
    FirebaseFirestore firebaseFirestore;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aswar);

        progressBar = findViewById(R.id.progressBar);
        List<String> urls = new ArrayList<>();
        RecyclerView recyclerView = findViewById(R.id.aswar_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

//        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        ImagesAdapter adapter = new ImagesAdapter(this, urls);
        recyclerView.setAdapter(adapter);

        firebaseFirestore = FirebaseFirestore.getInstance();
        firebaseFirestore.collection("Data")
                .get()
                .addOnSuccessListener(command -> {
                    Iterator<QueryDocumentSnapshot> iterator = command.iterator();
                    while (iterator.hasNext()){
                        QueryDocumentSnapshot queryDocumentSnapshot = iterator.next();
                        urls.add(queryDocumentSnapshot.getString("aswarImUrl"));
                        recyclerView.setAdapter(adapter);
                        progressBar.setVisibility(View.INVISIBLE);
                    }
                })
                .addOnFailureListener(command -> {
                    Toast.makeText(this, command.getMessage(), Toast.LENGTH_SHORT).show();
                });

    }
}