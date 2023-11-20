package com.example.xportacus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.xportacus.io.User;
import com.example.xportacus.io.UserLogin;
import com.example.xportacus.io.UserLoginApiAdapter;
import com.example.xportacus.io.UserRegister;
import com.example.xportacus.io.UserRegisterApiAdapter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText txtEmail, txtPassword;
    private Button LogIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtEmail = findViewById(R.id.sign_email);
        txtPassword = findViewById(R.id.password);
        LogIn = findViewById(R.id.login_button);

        LogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = txtEmail.getText().toString().trim();
                String password = txtPassword.getText().toString().trim();

                UserLogin apiService = UserLoginApiAdapter.getApiService();
                Call<User> call = apiService.User(email,password);

                call.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        if (response.isSuccessful() && response.body() != null){
                            String Email = response.body().getEmail();
                            System.out.println(response.body());
                            //Toast.makeText(getApplicationContext(),"hola: "+response.body(), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),"error: "+t, Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });
    }

    public void go_to_register(View view)
    {
        Intent register=new Intent(MainActivity.this,qrActivity.class);
        startActivity(register);
    }

}