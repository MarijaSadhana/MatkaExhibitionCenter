package com.example.matkaexhibitioncenter.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.matkaexhibitioncenter.R;

public class VideoDetailsActivity extends AppCompatActivity {

    public static final String TAG = VideoDetailsActivity.class.getSimpleName();
    public static final String VIDEO = "video";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_details);
    }
}
