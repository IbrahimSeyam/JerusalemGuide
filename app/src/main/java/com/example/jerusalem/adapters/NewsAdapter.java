package com.example.jerusalem.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jerusalem.R;
import com.example.jerusalem.model.Article;
import com.squareup.picasso.Picasso;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder>{
    Context context;
    List<Article> articles;

    public NewsAdapter(Context context, List<Article> articles) {
        this.context = context;
        this.articles = articles;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.new_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Article n = articles.get(position);

//        New n = news.get(position);
        Picasso.get().load(n.getURLToImage()).fit().centerCrop().placeholder(R.drawable.ic_launcher_background).into(holder.newImage);
        holder.titleTv.setText(n.getTitle());
        holder.descTv.setText(n.getDescription());
        holder.contentTv.setText(n.getContent());
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView newImage;
        TextView titleTv, descTv, contentTv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            newImage = itemView.findViewById(R.id.newImage);
            titleTv = itemView.findViewById(R.id.titleTv);
            descTv = itemView.findViewById(R.id.descTv);
            contentTv = itemView.findViewById(R.id.contentTv);
        }
    }
}
