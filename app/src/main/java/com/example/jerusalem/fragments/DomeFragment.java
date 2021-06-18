package com.example.jerusalem.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jerusalem.R;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.squareup.picasso.Picasso;

import java.util.Iterator;


public class DomeFragment extends Fragment {
    FirebaseFirestore firebaseFirestore;
    ImageView camIm2;
    TextView camTitleTv2, camDescTv2;
    ProgressBar progressBar;

    public DomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initViews(view);
        firebaseFirestore = FirebaseFirestore.getInstance();
        firebaseFirestore.collection("Camera")
                .get()
                .addOnSuccessListener(command -> {
                    Iterator<QueryDocumentSnapshot> iterator = command.iterator();
                    while (iterator.hasNext()) {
                        QueryDocumentSnapshot queryDocumentSnapshot = iterator.next();

                        Picasso.get().load(queryDocumentSnapshot.getString("camImUrl2")).fit().centerCrop().placeholder(R.mipmap.ic_launcher).into(camIm2);
                        camTitleTv2.setText(queryDocumentSnapshot.getString("camTitle2"));
                        camDescTv2.setText(queryDocumentSnapshot.getString("camDesc2"));
                        progressBar.setVisibility(View.INVISIBLE);
                    }
                })
                .addOnFailureListener(command -> {
                    Toast.makeText(getContext(), command.getMessage(), Toast.LENGTH_SHORT).show();
                });


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dome, container, false);
        return view;
    }

    private void initViews(View view) {
        camIm2 = view.findViewById(R.id.camIm2);
        camTitleTv2 = view.findViewById(R.id.camTitleTv2);
        camDescTv2 = view.findViewById(R.id.camDescTv2);
        progressBar = view.findViewById(R.id.progressBar);

    }
}