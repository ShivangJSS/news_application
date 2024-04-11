package com.example.newsapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.material.progressindicator.LinearProgressIndicator;
import com.kwabenaberko.newsapilib.NewsApiClient;
import com.kwabenaberko.newsapilib.models.Article;
import com.kwabenaberko.newsapilib.models.request.TopHeadlinesRequest;
import com.kwabenaberko.newsapilib.models.response.ArticleResponse;

import java.util.ArrayList;
import java.util.List;

public class api extends AppCompatActivity implements View.OnClickListener {
    Button btnnb1,btnnb2,btnnb3,btnnb4,btnnb5,btnnb6,btnnb7;
    RecyclerView recyclerView;
    List<Article> articleList=new ArrayList<>();
    recycleradapter adapter;
    LinearProgressIndicator progressIndicator;

    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api);
        recyclerView=findViewById(R.id.recycler_view);
progressIndicator=findViewById(R.id.progress);
        btnnb1=findViewById(R.id.btnnb1);
        btnnb2=findViewById(R.id.btnnb2);
        btnnb3=findViewById(R.id.btnnb3);
        btnnb4=findViewById(R.id.btnnb4);
        btnnb5=findViewById(R.id.btnnb5);
        btnnb6=findViewById(R.id.btnnb6);
        btnnb7=findViewById(R.id.btnnb7);
        btnnb1.setOnClickListener(this);
        btnnb2.setOnClickListener(this);
        btnnb3.setOnClickListener(this);
        btnnb4.setOnClickListener(this);
        btnnb5.setOnClickListener(this);
        btnnb6.setOnClickListener(this);
        btnnb7.setOnClickListener(this);

setupRecyclerView();
getNews("General");
}
void setupRecyclerView(){
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter=new recycleradapter(articleList);
        recyclerView.setAdapter(adapter);
}

void changeInProgress(boolean show){
        if(show)
       progressIndicator.setVisibility(View.VISIBLE);
        else
            progressIndicator.setVisibility(View.INVISIBLE);
}
void getNews(String category)
{
    changeInProgress(true);
    NewsApiClient newsApiClient=new NewsApiClient("346859a897244467b0f8db27a6781630");
    newsApiClient.getTopHeadlines(
            new TopHeadlinesRequest.Builder()
                    .language("en")
                    .category(category)
                    .build(),
            new NewsApiClient.ArticlesResponseCallback() {
                @Override
                public void onSuccess(ArticleResponse response) {

                    runOnUiThread(()->{
                        changeInProgress(false);
                        articleList= response.getArticles();
                        adapter.updateData(articleList);
                        adapter.notifyDataSetChanged();
                    });

                }

                @Override
                public void onFailure(Throwable throwable) {
                    Log.i("got throwable",throwable.getMessage());
                }
            }
    );
}

    @Override
    public void onClick(View v) {
    Button btn=(Button) v;
    String category=btn.getText().toString();
    getNews(category);
    }
}
