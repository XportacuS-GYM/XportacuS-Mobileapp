package com.example.xportacus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void go_to_register(View view)
    {
        Intent register=new Intent(MainActivity.this,RegisterActivity.class);
        startActivity(register);
    }

    public void go_to_video(View view)
    {
        Intent video=new Intent(MainActivity.this,VideoActivity.class);
        startActivity(video);
    }

}