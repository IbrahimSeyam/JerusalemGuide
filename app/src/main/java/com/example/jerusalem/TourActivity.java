package com.example.jerusalem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

public class TourActivity extends AppCompatActivity {
    AdView adView;
    InterstitialAd minterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour);

        Button aswarBtn = findViewById(R.id.aswarBtn);
        aswarBtn.setOnClickListener(v -> {
            startActivity(new Intent(TourActivity.this, AswarActivity.class));
        });

        Button aqsaMBtn = findViewById(R.id.aqsaMBtn);
        aqsaMBtn.setOnClickListener(v -> {
            startActivity(new Intent(TourActivity.this, AqsaMosqueActivity.class));
        });

        Button tourVideoBtn = findViewById(R.id.tourVideoBtn);
        tourVideoBtn.setOnClickListener(v -> {
            startActivity(new Intent(TourActivity.this, TourVideoActivity.class));
        });

        adView = findViewById(R.id.adView);
        MobileAds.initialize(this);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);


/*        InterstitialAd.load(this, "ca-app-pub-3940256099942544/1033173712", adRequest, new InterstitialAdLoadCallback() {
            @Override
            public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                super.onAdLoaded(interstitialAd);

                minterstitialAd = interstitialAd;
//                interstitialAd.show(new TourActivity());
                Toast.makeText(TourActivity.this, "on Ad loaded", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                super.onAdFailedToLoad(loadAdError);
                Toast.makeText(TourActivity.this, loadAdError.getMessage(), Toast.LENGTH_SHORT).show();
                minterstitialAd = null;
            }
        });*/
    }
}