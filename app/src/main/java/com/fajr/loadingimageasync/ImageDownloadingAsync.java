package com.fajr.loadingimageasync;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ImageDownloadingAsync extends AsyncTask<String,String,Bitmap> {

    private ProgressBar progressBar;
    private ImageView imageView;
    private MainActivity mainActivity;

    ImageDownloadingAsync(MainActivity mainActivity, ProgressBar progressBar, ImageView imageView) {
        this.mainActivity = mainActivity;
        this.progressBar = progressBar;
        this.imageView = imageView;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Bitmap doInBackground(String... strings) {
        Bitmap bmp = null;
        try {
            URL url = new URL(strings[0]);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            bmp = BitmapFactory.decodeStream(inputStream);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bmp;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        imageView.setImageBitmap(bitmap);
        imageView.setAnimation(AnimationUtils.loadAnimation(mainActivity, android.R.anim.fade_in));
        progressBar.setVisibility(View.GONE);
        super.onPostExecute(bitmap);
    }
}
