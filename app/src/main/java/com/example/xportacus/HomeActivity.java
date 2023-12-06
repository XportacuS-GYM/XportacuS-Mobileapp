package com.example.xportacus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements RecyclerViewInterface{
    ArrayList<RutinasModel> rutinasModels = new ArrayList<>();
    int [] rutinasImages = {R.drawable.gym_r1, R.drawable.gym_r2, R.drawable.gym_r3, R.drawable.gym_r4, R.drawable.gym_r5,
            R.drawable.gym_r6, R.drawable.gym_r7, R.drawable.gym_r8, R.drawable.gym_r9, R.drawable.gym_r10, R.drawable.gym_r11,
            R.drawable.gym_r12, R.drawable.gym_r13, R.drawable.gym_r14, R.drawable.gym_r15 ,R.drawable.gym_r16};

    int [] rutinasVideos= {R.raw.aperturas_invertidas, R.raw.curl_antebrazo_agarre_prono, R.raw.curl_antebrazo_agarre_supino, R.raw.curl_biceps_barra_z, R.raw.elevaciones_laterales_en_polea,
        R.raw.extension_de_triceps_unilateral,R.raw.hip_trust,R.raw.jalon_al_pecho_agarre_estrecho,R.raw.martillos_unilateral,R.raw.pec_fly,R.raw.peso_muerto,R.raw.press_banca_inclinado,
        R.raw.press_banca_recto,R.raw.press_frances_barra_z,R.raw.press_militar,R.raw.remo_sentado_agarre_cerrado};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        BottomNavigationView bottomNavigation = findViewById(R.id.bottomNavigation);
        bottomNavigation.setSelectedItemId(R.id.bottom_home);

        Bundle datos = getIntent().getExtras();
        String emailqr = datos.getString("email");
        String name=datos.getString("name");
        String adress=datos.getString("direccion");
        int age=datos.getInt("edad");
        String sub=datos.getString("estatussub");
        String token = datos.getString("token");

        bottomNavigation.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.bottom_home) {
                return true;
            } else if (itemId == R.id.bottom_lectorqr) {
                Intent intent = new Intent(getApplicationContext(), lectorqr.class);
                intent.putExtra("token", token);
                startActivity(intent);
                //startActivity(new Intent(getApplicationContext(), lectorqr.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                return true;
            } else if (itemId == R.id.bottom_miqr) {
                Intent intent = new Intent(getApplicationContext(), userqr.class);
                intent.putExtra("email", emailqr);
                intent.putExtra("name",name);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                return true;
            } else if (itemId == R.id.bottom_profile) {
                //startActivity(new Intent(getApplicationContext(), UserProfile.class));
                Intent intent = new Intent(getApplicationContext(), UserProfile.class);
                intent.putExtra("email", emailqr);
                intent.putExtra("name",name);
                intent.putExtra("direccion",adress);
                intent.putExtra("edad",age);
                intent.putExtra("estatussub",sub);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                return true;
            }
            return false;
        });

        RecyclerView recyclerView = findViewById(R.id.mRecyclerView);
        setUpRutinasModels();
        R_RecyclerViewAdapter adapter = new R_RecyclerViewAdapter(this, rutinasModels, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setUpRutinasModels(){
        String [] rutinas_nombres = getResources().getStringArray(R.array.titulos_de_video);
        String [] descrip_rutinas = getResources().getStringArray(R.array.descrip_rutinas);

        for (int i = 0; i<rutinas_nombres.length; i++){
            rutinasModels.add(new RutinasModel(rutinas_nombres[i],
                    descrip_rutinas[i],
                    rutinasImages[i],
                    rutinasVideos[i]));
        }
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(HomeActivity.this, VideoActivity.class);

        intent.putExtra("TITULO", rutinasModels.get(position).getTitulos_de_video());
        intent.putExtra("VIDEO", rutinasModels.get(position).getVideo());

        startActivity(intent);
    }
}