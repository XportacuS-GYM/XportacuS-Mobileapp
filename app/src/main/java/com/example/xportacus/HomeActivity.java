package com.example.xportacus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    ArrayList<RutinasModel> rutinasModels = new ArrayList<>();
    int [] rutinasImages = {R.drawable.gym_r1, R.drawable.gym_r2, R.drawable.gym_r3, R.drawable.gym_r4, R.drawable.gym_r5,
            R.drawable.gym_r6, R.drawable.gym_r7, R.drawable.gym_r8, R.drawable.gym_r9, R.drawable.gym_r10, R.drawable.gym_r11,
            R.drawable.gym_r12, R.drawable.gym_r13, R.drawable.gym_r14, R.drawable.gym_r15 ,R.drawable.gym_r16};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        BottomNavigationView bottomNavigation = findViewById(R.id.bottomNavigation);
        bottomNavigation.setSelectedItemId(R.id.bottom_home);

        bottomNavigation.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.bottom_home) {
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
                startActivity(new Intent(getApplicationContext(), VideoActivity.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
                return true;
            }
            return false;
        });

        RecyclerView recyclerView = findViewById(R.id.mRecyclerView);
        setUpRutinasModels();
        R_RecyclerViewAdapter adapter = new R_RecyclerViewAdapter(this, rutinasModels);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setUpRutinasModels(){
        String [] rutinas_nombres = getResources().getStringArray(R.array.titulos_de_video);
        String [] descrip_rutinas = getResources().getStringArray(R.array.descrip_rutinas);

        for (int i = 0; i<rutinas_nombres.length; i++){
            rutinasModels.add(new RutinasModel(rutinas_nombres[i],
                    descrip_rutinas[i],
                    rutinasImages[i]));
        }
    }
}