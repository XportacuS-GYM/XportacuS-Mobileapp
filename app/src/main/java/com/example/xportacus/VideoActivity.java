package com.example.xportacus;

import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class VideoActivity extends AppCompatActivity {
    private VideoView vv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        vv1.findViewById(R.id.vv1);

        vv1.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.video1));

        vv1.start();
    }
}
