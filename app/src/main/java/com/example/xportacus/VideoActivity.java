package com.example.xportacus;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class VideoActivity extends AppCompatActivity {
    private VideoView vv1;
    private ImageButton btnVideo;
    private TextView durVideo;
    private Handler handler;
    private Runnable updateDurationRunnable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        vv1=findViewById(R.id.vv1);
        btnVideo = findViewById(R.id.btnVideo);
        durVideo = findViewById(R.id.durVideo);

        handler = new Handler();

        String titulo = getIntent().getStringExtra("TITULO");
        int video = getIntent().getIntExtra("VIDEO", 0);
        TextView tituloV = findViewById(R.id.TituloVideo);

        tituloV.setText(titulo);
        vv1.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+video));

        //String videoUrl = "https://youtube.com/shorts/3I7X5e-42pE?si=Fvzzwsy-sqzsSSty";
        //vv1.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.curl_biceps_barra_z));
        vv1.start();

        // Inicializar el Runnable para actualizar la duración
        updateDurationRunnable = new Runnable() {
            @Override
            public void run() {
                updateDuration();
                handler.postDelayed(this, 1000);
            }
        };
        handler.post(updateDurationRunnable);
        
        //boton para pausar y poner play al video
        btnVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (vv1.isPlaying()) {
                    vv1.pause();
                    btnVideo.setImageResource(android.R.drawable.ic_media_play);
                } else {
                    vv1.start();
                    btnVideo.setImageResource(android.R.drawable.ic_media_pause);
                }
            }
        });
    }

    private void updateDuration() {
        int currentPosition = vv1.getCurrentPosition();

        // Actualizar el TextView con la duración actual
        durVideo.setText(formatTime(currentPosition));
    }
    private String formatTime(int millis) {
        int seconds = millis / 1000;
        int minutes = seconds / 60;
        seconds = seconds % 60;
        return String.format("%02d:%02d", minutes, seconds);
    }
    public void go_to_home(View view)
    {
        Intent home=new Intent(VideoActivity.this,HomeActivity.class);
        startActivity(home);
        finish();
    }
}
