package com.example.jerusalem.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jerusalem.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CameraAdapter extends RecyclerView.Adapter<CameraAdapter.ViewHolder> {
    Context context;
    List<String> imageUrls;
    List<String> titles;
    List<String> desc;

    public CameraAdapter(Context context, List<String> imageUrls, List<String> titles, List<String> desc) {
        this.context = context;
        this.imageUrls = imageUrls;
        this.titles = titles;
        this.desc = desc;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.camera_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String url = "";
        String title = "";
        String description = "";

        if (imageUrls != null && imageUrls.size() != 0 || titles != null && titles.size() != 0 || desc != null && desc.size() != 0) {
            url = imageUrls.get(position);
            title = titles.get(position);
            description = desc.get(position);
        } else {
            Toast.makeText(context, "yr", Toast.LENGTH_SHORT).show();
        }


        Picasso.get().load(url).fit().centerCrop().placeholder(R.mipmap.ic_launcher).into(holder.camIm);
        holder.camTitleTv.setText(title);
        holder.camDescTv.setText(description);
    }

    @Override
    public int getItemCount() {
        return imageUrls.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView camIm;
        TextView camTitleTv, camDescTv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            camIm = itemView.findViewById(R.id.camIm2);
            camTitleTv = itemView.findViewById(R.id.camTitleTv2);
            camDescTv = itemView.findViewById(R.id.camDescTv2);
        }
    }
}
