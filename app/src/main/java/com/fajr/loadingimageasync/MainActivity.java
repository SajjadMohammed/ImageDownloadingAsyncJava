package com.fajr.loadingimageasync;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    ProgressBar progressBar;
    Toolbar V7ToolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        V7ToolBar=findViewById(R.id.toolbar);
        setSupportActionBar(V7ToolBar);

        imageView = findViewById(R.id.myImage);
        progressBar = findViewById(R.id.myProgressBar);

        String url = "https://avatars2.githubusercontent.com/u/30750038?s=460&v=4";
        new ImageDownloadingAsync(this, progressBar, imageView).execute(url);
    }
}