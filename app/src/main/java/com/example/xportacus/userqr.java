package com.example.xportacus;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.xportacus.io.User;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class userqr extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userqr);



        TextView txtDatos=findViewById(R.id.txtEmail);

        Bundle intent=getIntent().getExtras();

        String emailqr=intent.getString("email");

        txtDatos.setText(emailqr);

        Button btnGuardar= findViewById(R.id.idBtnGenerateQR);
        ImageView qrImage=findViewById(R.id.idIVQrcode);

        txtDatos.setVisibility(View.INVISIBLE);
        btnGuardar.setOnClickListener(new View.OnClickListener()
                                      {
                                          @Override
                                          public void onClick(View view) {
                                              try {
                                                  BarcodeEncoder barcodeEncoder=new BarcodeEncoder();
                                                  Bitmap bitmap= barcodeEncoder.encodeBitmap(txtDatos.getText().toString(), BarcodeFormat.QR_CODE,750,750);
                                                  qrImage.setImageBitmap(bitmap);
                                              } catch (WriterException e) {
                                                  e.printStackTrace();
                                              }
                                          }
        }
        );



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
                startActivity(new Intent(getApplicationContext(), UserProfile.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
                return true;
            }
            return false;
        });
    }
}