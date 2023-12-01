package com.example.xportacus;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.xportacus.io.ApiTaskUser;
import com.example.xportacus.io.User;
import com.example.xportacus.io.UserInfo;
import com.example.xportacus.io.UserInfoApiAdapter;
import com.example.xportacus.io.UserLogin;
import com.example.xportacus.io.UserLoginApiAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class lectorqr extends AppCompatActivity {

    TextView txtEmail;
    TextView txtNombre;
    TextView txtStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lectorqr);

        txtEmail=findViewById(R.id.txtEmail);
        txtNombre=findViewById(R.id.txtName);
        txtStatus=findViewById(R.id.txtEstatusSub);
        new IntentIntegrator(this).initiateScan();

        BottomNavigationView bottomNavigation = findViewById(R.id.bottomNavigation);
        bottomNavigation.setSelectedItemId(R.id.bottom_lectorqr);

        bottomNavigation.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.bottom_home) {
                startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
                return true;
            } else if (itemId == R.id.bottom_lectorqr) {
                return true;
            } else if (itemId == R.id.bottom_miqr) {
                startActivity(new Intent(getApplicationContext(), userqr.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
                return true;
            } else if (itemId == R.id.bottom_profile) {
                startActivity(new Intent(getApplicationContext(), VideoActivity.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
                return true;
            }
            return false;
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        IntentResult result=IntentIntegrator.parseActivityResult(requestCode,resultCode,data);

        Bundle datos = getIntent().getExtras();
        String token = datos.getString("token");

        String email=result.getContents();

        new ApiTaskUser(txtEmail, txtNombre, txtStatus).execute(email,token);
    }

}