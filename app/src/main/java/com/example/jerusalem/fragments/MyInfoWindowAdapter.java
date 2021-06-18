package com.example.jerusalem.fragments;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.jerusalem.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

public class MyInfoWindowAdapter implements GoogleMap.InfoWindowAdapter {

    Context context;
    public MyInfoWindowAdapter(Context context){
        this.context = context;
    }

    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }

    @Override
    public View getInfoContents(Marker marker) {
        View view = LayoutInflater.from(context).inflate(R.layout.marker_widget,null);
        ImageView im = view.findViewById(R.id.imageView);
        im.setImageResource(R.drawable.quds);
        view.setLayoutParams(new LinearLayout.LayoutParams(400,300));
        return view;
    }
}
