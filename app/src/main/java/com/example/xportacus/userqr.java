package com.example.xportacus;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class userqr extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userqr);

        TextView txtDatos=findViewById(R.id.idEdt);
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
    }
}