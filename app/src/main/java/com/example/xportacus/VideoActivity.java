package com.example.xportacus;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class VideoActivity extends AppCompatActivity {
    private VideoView vv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        vv1.findViewById(R.id.vv1);

        vv1.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.video1));

        vv1.start();


        BottomNavigationView bottomNavigation = findViewById(R.id.bottomNavigation);
        bottomNavigation.setSelectedItemId(R.id.bottom_miqr);

        bottomNavigation.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.bottom_home) {
                startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
                return true;
            } else if (itemId == R.id.bottom_lectorqr) {
                startActivity(new Intent(getApplicationContext(), lectorqr.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
                return true;
            } else if (itemId == R.id.bottom_miqr) {
                startActivity(new Intent(getApplicationContext(), userqr.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
                return true;
            } else if (itemId == R.id.bottom_profile) {
                return true;
            }
            return false;
        });
    }
}
