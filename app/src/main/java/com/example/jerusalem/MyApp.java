package com.example.jerusalem;

import android.app.Application;
import android.content.res.Resources;
import android.util.DisplayMetrics;

import com.example.jerusalem.service.RetrofitService;

import java.util.Locale;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyApp extends Application {
    static RetrofitService retrofitService;

    @Override
    public void onCreate() {
        super.onCreate();

        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        android.content.res.Configuration conf = res.getConfiguration();
        conf.setLocale(new Locale("ar".toLowerCase()));
        res.updateConfiguration(conf, dm);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        retrofitService = retrofit.create(RetrofitService.class);

    }
}
