package com.example.jerusalem.fragments;

import android.content.res.AssetManager;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jerusalem.R;
import com.google.vr.sdk.widgets.pano.VrPanoramaView;

import java.io.InputStream;


public class Photos360Fragment extends Fragment {
    VrPanoramaView vrPanoramaView;


    public Photos360Fragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_photos360, container, false);
        vrPanoramaView = view.findViewById(R.id.vrPanoramaView);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadPhotoSphere();
    }

    private void loadPhotoSphere() {
        VrPanoramaView.Options options = new VrPanoramaView.Options();
        InputStream inputStream = null;

        AssetManager assetManager = getContext().getAssets();
        try {
            inputStream = assetManager.open("panorama.jpg");
            options.inputType = VrPanoramaView.Options.TYPE_MONO;
            vrPanoramaView.loadImageFromBitmap(BitmapFactory.decodeStream(inputStream), options);
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}