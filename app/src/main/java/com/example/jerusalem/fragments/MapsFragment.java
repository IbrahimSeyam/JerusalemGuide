package com.example.jerusalem.fragments;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.jerusalem.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import static android.content.Context.LOCATION_SERVICE;

public class MapsFragment extends Fragment {
    private GoogleMap mMap;

    private OnMapReadyCallback callback = new OnMapReadyCallback() {

        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        @Override
        public void onMapReady(GoogleMap googleMap) {
/*            LatLng sydney = new LatLng(-34, 151);
            googleMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));*/

            mMap = googleMap;
            UiSettings settings = mMap.getUiSettings();
//            settings.setZoomControlsEnabled(true);
            settings.setCompassEnabled(true);
            settings.setMyLocationButtonEnabled(true);
            mMap.setTrafficEnabled(true);
            mMap.setBuildingsEnabled(true);
            if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, 0);
            }

//            mMap.setMyLocationEnabled(true);
            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.title("Jerusalem, Capital of Palestine");
            LatLng latLng = new LatLng(31.771959, 35.217018);
            markerOptions.position(latLng);

            Marker marker2 = mMap.addMarker(markerOptions);
            marker2.setTag("ALQuds");

            MyInfoWindowAdapter infoWindowAdapter  = new MyInfoWindowAdapter(getContext());
            mMap.setInfoWindowAdapter(infoWindowAdapter);

            mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));

            mMap.setOnMarkerClickListener(marker -> {
//                if (marker.getTag().toString().equals("AlQuds")){
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("https://www.google.com/maps/place/%D8%A7%D9%84%D8%AD%D8%B1%D9%85+%D8%A7%D9%84%D9%82%D8%AF%D8%B3%D9%8A+%D8%A7%D9%84%D8%B4%D8%B1%D9%8A%D9%81%E2%80%AD/@30.6703747,36.6231118,7.67z/data=!4m12!1m6!3m5!1s0x0:0x6d2bbd5ce62d60ab!2z2KfZhNit2LHZhSDYp9mE2YLYr9iz2Yog2KfZhNi02LHZitmB!8m2!3d31.7781161!4d35.2359927!3m4!1s0x0:0x6d2bbd5ce62d60ab!8m2!3d31.7781161!4d35.2359927"));
                    startActivity(intent);
//                }
                return false;
            });

        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_maps, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }

        final LocationManager locationManager = (LocationManager) getContext().getSystemService(LOCATION_SERVICE);
        boolean isGPSEnable = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        if (!isGPSEnable) {
            Toast.makeText(getContext(), "Please Enable GPS", Toast.LENGTH_SHORT).show();
        }
    }
}