package com.example.extream.personal_assistant;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class splash extends AppCompatActivity {
    ImageView temporal_logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        temporal_logo = findViewById(R.id.templogo);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.splash);
        RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(getResources(),bitmap);
        roundedBitmapDrawable.setCircular(true);
        temporal_logo.setImageDrawable(roundedBitmapDrawable);

    }
}
