package com.example.jerusalem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.animation.Animation;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.example.jerusalem.adapters.NewsAdapter;
import com.example.jerusalem.model.Article;
import com.example.jerusalem.response.ArticleResponse;
import com.google.vr.sdk.widgets.pano.VrPanoramaView;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import co.gofynd.gravityview.GravityView;
import retrofit2.Response;

public class NewsActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    List<Article> articles = new ArrayList<>();
    RecyclerView recyclerView;
    NewsAdapter adapter;
    SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        swipeRefreshLayout = findViewById(R.id.swipe_refresh);
        swipeRefreshLayout.setColorSchemeColors(Color.BLUE);
        recyclerView = findViewById(R.id.news_recyclerView);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(NewsActivity.this));


        SimpleDateFormat formatter =  new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());

        final String currentTimeFormatted = formatter.format(System.currentTimeMillis());

        final long aMonthAgoTime = System.currentTimeMillis() - (30 * 24 * 60 * 60 * 1000L);

        final String aMonthAgoTimeFormatted = formatter.format(aMonthAgoTime);

        new MyAsync(aMonthAgoTimeFormatted,currentTimeFormatted).execute();

        swipeRefreshLayout.setOnRefreshListener(() -> {
//            Collections.shuffle(articles, new Random(System.currentTimeMillis()));

                swipeRefreshLayout.setRefreshing(false);

        });

    }
    class MyAsync extends AsyncTask<Void, Void, Void> {

        private final String fromDate;
        private final String toDate;

        public MyAsync(String fromDate,String toDate){
            this.fromDate = fromDate;
            this.toDate = toDate;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            Log.d(TAG, "doInBackground: onCreate");
            try {
                Response<ArticleResponse> response = MyApp.retrofitService
                        .getArticle("%D8%A7%D9%84%D9%82%D8%AF%D8%B3", fromDate, toDate, "popularity", "1889bccd4d2e489daf7b06fb413da1ea")
                        .execute();
                if (response.isSuccessful()){
//                    Log.d(TAG, "onCreate: Body " + response.body().getArticles());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            articles = response.body().getArticles();
//                            articles.add(new Article());
//                            adapter.notifyDataSetChanged();
                            adapter = new NewsAdapter(NewsActivity.this, articles);
                            recyclerView.setAdapter(adapter);

                        }
                    });

                } else {
                    Log.e(TAG, "onCreate: Something error");
                }
            } catch (IOException e) {
                Log.d("ttt",e.getMessage());
                e.printStackTrace();
            }
            return null;
        }
    }


}