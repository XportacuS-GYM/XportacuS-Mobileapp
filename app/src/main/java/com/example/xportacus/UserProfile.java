package com.example.xportacus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class UserProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        BottomNavigationView bottomNavigation = findViewById(R.id.bottomNavigation);
        bottomNavigation.setSelectedItemId(R.id.bottom_home);

        TextView txtName=findViewById(R.id.txtName);
        TextView txtemail=findViewById(R.id.txtEmail);
        TextView txtDireccion=findViewById(R.id.txtDireccionProfile);
        TextView txtEdad=findViewById(R.id.txtEdadProfile);
        TextView txtEstatus=findViewById(R.id.txtEstatusSub);

        Bundle Intent=getIntent().getExtras();


        String emailqr=Intent.getString("email");
        String name=Intent.getString("name");
        String adress=Intent.getString("direccion");
        int age=Intent.getInt("edad");
        String sub=Intent.getString("estatussub");
        String token = Intent.getString("token");

        txtName.setText(name);
        txtemail.setText(emailqr);
        txtDireccion.setText(adress);
        txtEdad.setText(age);
        txtEstatus.setText(sub);

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