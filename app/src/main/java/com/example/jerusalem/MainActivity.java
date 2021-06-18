package com.example.jerusalem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.example.jerusalem.adapters.NewsAdapter;
import com.example.jerusalem.model.Article;
import com.example.jerusalem.response.ArticleResponse;
import com.google.vr.sdk.widgets.pano.VrPanoramaView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import co.gofynd.gravityview.GravityView;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    RequestQueue requestQueue;
    List<Article> articles = new ArrayList<>();
    ImageView imageView;
    GravityView gravityView;
    boolean es = false;
    VrPanoramaView vrPanoramaView;
    RecyclerView recyclerView;
    NewsAdapter adapter;
    Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        android.content.res.Configuration conf = res.getConfiguration();
        conf.setLocale(new Locale("ar".toLowerCase()));
        res.updateConfiguration(conf, dm);

        TextView textView = findViewById(R.id.mainTv);
        animation = AnimationUtils.loadAnimation(this, R.anim.fromtop);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                new Thread(() -> {
                    try {
                        Thread.sleep(1500);
                        startActivity(new Intent(MainActivity.this, HomeActivity.class));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }).start();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        textView.setAnimation(animation);

//        recyclerView = findViewById(R.id.recyclerView);
//        recyclerView.setHasFixedSize(true);

//        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));


//        new MyAsync().execute();




//        vrPanoramaView = findViewById(R.id.vrPanoramaView);



        String url = "https://www.google.com/maps/uv?pb=!1s0x150329c91f33ffdb%3A0x6d2bbd5ce62d60ab!3m1!7e115!4shttps%3A%2F%2Flh5.googleusercontent.com%2Fp%2FAF1QipN8O6DxK_efXns4qxqdYm0_7WAcT0NjX615ywhM%3Dw213-h160-k-no!5z2KfZhNmF2LPYrNivINin2YTYp9mC2LXZiSAtINio2K3YqyBHb29nbGXigI8!15sCgIgARICCAI&imagekey=!1e10!2sAF1QipPMZDjzwCO1_yo5frQ8IvhVWA8d3BunGMyAzFsR&hl=ar&sa=X&ved=2ahUKEwiZksHOjNbwAhUu_7sIHcNLCgAQoiowKXoECHIQAw";
//        imageView = findViewById(R.id.imageView);
/*        gravityView = GravityView.getInstance(getBaseContext());
        es = gravityView.deviceSupported();
        if (es){
            gravityView.setImage(imageView, R.drawable.q).center();
        } else {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.q);
            imageView.setImageBitmap(bitmap);
        }*/
//        Picasso.get().load(url)
//                .into();


/*
        requestQueue = Volley.newRequestQueue(this);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        news = new ArrayList<>();
        NewsAdapter adapter = new NewsAdapter(this, news);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        String url = "https://newsapi.org/v2/top-headlines?sources=bbc-news&apiKey=1889bccd4d2e489daf7b06fb413da1ea";

//        JSONArray articles = object.getJSONArray("articles");
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, response -> {
            for (int i = 0; i < response.length(); i++) {
                try {
                    New n = new New();
                    JSONObject object = response.getJSONObject(i);
                    n.setImageUrl(object.getString("urlToImage"));
                    n.setTitle(object.getString("title"));
                    n.setDescription(object.getString("description"));
                    n.setContent(object.getString("content"));

                    news.add(n);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, error -> {
            Toast.makeText(this, error.getMessage(), Toast.LENGTH_SHORT).show();
        });
        requestQueue.add(jsonArrayRequest);

*/

    }

    class MyAsync extends AsyncTask<Void, Void, Void>{

        @Override
        protected Void doInBackground(Void... voids) {
            Log.d(TAG, "doInBackground: onCreate");
            try {
                Response<ArticleResponse> response = MyApp.retrofitService
                        .getArticle("%D8%A7%D9%84%D9%82%D8%AF%D8%B3", "2021-05-08", "2021-05-10", "popularity", "1889bccd4d2e489daf7b06fb413da1ea")
                        .execute();
                if (response.isSuccessful()){
//                    Log.d(TAG, "onCreate: Body " + response.body().getArticles());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            articles = response.body().getArticles();
//                            articles.add(new Article());
//                            adapter.notifyDataSetChanged();
                            adapter = new NewsAdapter(MainActivity.this, articles);
                            recyclerView.setAdapter(adapter);

                        }
                    });

                } else {
                    Log.e(TAG, "onCreate: Something error");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

/*    @Override
    protected void onPause() {
        vrPanoramaView.pauseRendering();
        super.onPause();
    }

    @Override
    protected void onResume() {
        vrPanoramaView.resumeRendering();
        super.onResume();
//        gravityView.registerListener();
    }

    @Override
    protected void onDestroy() {
        vrPanoramaView.shutdown();
        super.onDestroy();
    }*/

    private void loadPhotoSphere() {
        VrPanoramaView.Options options = new VrPanoramaView.Options();
        InputStream inputStream = null;

        AssetManager assetManager = getAssets();
        try {
            inputStream = assetManager.open("panorama.jpg");
            options.inputType = VrPanoramaView.Options.TYPE_MONO;
            vrPanoramaView.loadImageFromBitmap(BitmapFactory.decodeStream(inputStream), options);
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /*    @Override
    protected void onStop() {
        super.onStop();
        gravityView.unRegisterListener();
    }*/
}