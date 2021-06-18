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

public class AlqeyamaFragment extends Fragment {
    FirebaseFirestore firebaseFirestore;
    ImageView camIm3;
    TextView camTitleTv3, camDescTv3;
    ProgressBar progressBar;

    public AlqeyamaFragment() {
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

                        Picasso.get().load(queryDocumentSnapshot.getString("camImUrl3"))
                                .fit().centerCrop().placeholder(R.mipmap.ic_launcher).into(camIm3);
                        camTitleTv3.setText(queryDocumentSnapshot.getString("camTitle3"));
                        camDescTv3.setText(queryDocumentSnapshot.getString("camDesc3"));
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
        View view = inflater.inflate(R.layout.fragment_alqeyama, container, false);
        return view;
    }

    private void initViews(View view) {
        camIm3 = view.findViewById(R.id.camIm3);
        camTitleTv3 = view.findViewById(R.id.camTitleTv3);
        camDescTv3 = view.findViewById(R.id.camDescTv3);
        progressBar = view.findViewById(R.id.progressBar);
    }
}