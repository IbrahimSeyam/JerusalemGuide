package com.example.jerusalem.fragments;

import android.content.DialogInterface;
import android.graphics.Color;
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
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.squareup.picasso.Picasso;

import java.util.Iterator;


public class AlqiblyFragment extends Fragment{
    FirebaseFirestore firebaseFirestore;
    ImageView camIm;
    TextView camTitleTv, camDescTv;
    String[] colors = {"أحمر", "أخضر", "أزرق"};
    ProgressBar progressBar;


    public AlqiblyFragment() {
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

                        Picasso.get().load(queryDocumentSnapshot.getString("camImUrl"))
                                .fit().centerCrop().placeholder(R.mipmap.ic_launcher).into(camIm);
                        camTitleTv.setText(queryDocumentSnapshot.getString("camTitle"));
                        camDescTv.setText(queryDocumentSnapshot.getString("camDesc"));
                        progressBar.setVisibility(View.INVISIBLE);

                    }
                })
                .addOnFailureListener(command -> {
                    Toast.makeText(getContext(), command.getMessage(), Toast.LENGTH_SHORT).show();
                });

        camDescTv.setOnClickListener(v -> {
            MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(getContext())
                    .setTitle("تغيير لون النص")
                    .setItems(colors, new DialogInterface.OnClickListener(){
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            if (which == 0){
                                camDescTv.setTextColor(Color.RED);
                            }else  if (which == 1){
                                camDescTv.setTextColor(Color.GREEN);
                            }else if (which == 2){
                                camDescTv.setTextColor(Color.BLUE);
                            }
                        }
                    })
                    .setPositiveButton("إرجاع", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            camDescTv.setTextColor(Color.BLACK);
                        }
                    });
            builder.create().show();

        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_alqibly, container, false);
       //        camTitleTv.setOnClickListener(v -> {
//            camTitleTv.setTypeface(ResourcesCompat.getFont(getContext(), R.font.arial));
//        });

        return view;
    }

    private void initViews(View view) {
        camIm = view.findViewById(R.id.camIm);
        camTitleTv = view.findViewById(R.id.camTitleTv);
        camDescTv = view.findViewById(R.id.camDescTv);
        progressBar = view.findViewById(R.id.progressBar);

    }
}