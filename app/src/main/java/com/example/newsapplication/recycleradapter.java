package com.example.newsapplication;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kwabenaberko.newsapilib.models.Article;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

import java.util.List;

public class recycleradapter extends RecyclerView.Adapter<recycleradapter.NewsViewHolder> {

List<Article>articleList;
    recycleradapter(List<Article>articleList)
    {
this.articleList=articleList;
    }
    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_file,parent,false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
Article article=articleList.get(position);
holder.titleTextView.setText((article.getTitle() ));
holder.sourceTextView.setText(article.getSource().getName());
        Picasso.get().load(article.getUrlToImage())

        .error(R.drawable.baseline_hide_image_24)
                .placeholder(R.drawable.baseline_hide_image_24)
        .into(holder.imageView);
        holder.imageView.setOnClickListener(v -> {
            Intent intent=new Intent(v.getContext(),newFullActivity.class);
            v.getContext().startActivities(new Intent[]{intent});
        });
    }

   void updateData(List<Article> data){
        articleList.clear();
        articleList.addAll((data));
   }

    @Override
    public int getItemCount() {
        return articleList.size();
    }

    class NewsViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView,sourceTextView;
        ImageView imageView;
        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView=itemView.findViewById(R.id.article_title);
                    sourceTextView=itemView.findViewById(R.id.article_source);
            imageView=itemView.findViewById(R.id.article_image_view);
        }
    }
}
