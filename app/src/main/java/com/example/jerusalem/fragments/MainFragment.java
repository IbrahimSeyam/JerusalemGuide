package com.example.jerusalem.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.jerusalem.AqsaActivity;
import com.example.jerusalem.CameraActivity;
import com.example.jerusalem.HistoryActivity;
import com.example.jerusalem.NewsActivity;
import com.example.jerusalem.QudsActivity;
import com.example.jerusalem.R;
import com.example.jerusalem.TourActivity;

public class MainFragment extends Fragment {
    LinearLayout linearLayout;
    CardView historyCard, tourCard, cameraCard, aqsaCard, qudsCard, newsCard;

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        initViews(view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        historyCard.setOnClickListener(v -> {
            startActivity(new Intent(getContext(), HistoryActivity.class));
        });
        tourCard.setOnClickListener(v -> {
            startActivity(new Intent(getContext(), TourActivity.class));
        });
        cameraCard.setOnClickListener(v -> {
            startActivity(new Intent(getContext(), CameraActivity.class));
        });
        aqsaCard.setOnClickListener(v -> {
            startActivity(new Intent(getContext(), AqsaActivity.class));
//            Toast.makeText(getContext(), "المساجد", Toast.LENGTH_SHORT).show();
//            Snackbar.make(linearLayout, "المساجد", Snackbar.LENGTH_SHORT).show();
        });
        qudsCard.setOnClickListener(v -> {
            startActivity(new Intent(getContext(), QudsActivity.class));
        });
        newsCard.setOnClickListener(v -> {
            startActivity(new Intent(getContext(), NewsActivity.class));
        });

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }

    private void initViews(View view){
        linearLayout = view.findViewById(R.id.linearLayout);
        historyCard = view.findViewById(R.id.masajedCard);
        tourCard = view.findViewById(R.id.maathenCard);
        cameraCard = view.findViewById(R.id.gatesCard);
        aqsaCard = view.findViewById(R.id.bawaikCard);
        qudsCard = view.findViewById(R.id.domesCard);
        newsCard = view.findViewById(R.id.newsCard);
    }
}