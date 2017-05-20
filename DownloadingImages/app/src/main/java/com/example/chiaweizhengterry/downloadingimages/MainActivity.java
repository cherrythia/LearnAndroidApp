package com.example.chiaweizhengterry.downloadingimages;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    ImageView downloadImage;

    public void downloadImage(View view) {

        // https://s-media-cache-ak0.pinimg.com/originals/e2/ab/01/e2ab01e2a4eac747fca1b554ebd9b97e.gif

        ImageDownloader task = new ImageDownloader();
        Bitmap myImage;

        try {

            myImage = task.execute("https://upload.wikimedia.org/wikipedia/en/a/aa/Bart_Simpson_200px.png").get();

            downloadImage.setImageBitmap(myImage);

        } catch (Exception e) {

            e.printStackTrace();

        }

        Log.i("Interaction", "Button Tapped");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        downloadImage = (ImageView) findViewById(R.id.imageView);
    }

    public class ImageDownloader extends AsyncTask<String, Void ,Bitmap> {

        @Override
        protected Bitmap doInBackground(String... urls) {

            try {

                URL url = new URL(urls[0]);

                HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                connection.connect();

                InputStream inputStream = connection.getInputStream();

                Bitmap myBitMap = BitmapFactory.decodeStream(inputStream);

                Log.i("Bitmap", "Bitmap decoded");

                return myBitMap;

            } catch (MalformedURLException e) {

                e.printStackTrace();

            } catch (IOException e) {

                e.printStackTrace();

            }
            return null;
        }
    }

}
