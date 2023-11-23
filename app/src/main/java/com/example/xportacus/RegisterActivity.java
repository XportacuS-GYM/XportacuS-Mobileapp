package com.example.xportacus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.xportacus.io.User;
import com.example.xportacus.io.UserRegister;
import com.example.xportacus.io.UserRegisterApiAdapter;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RegisterActivity extends AppCompatActivity {


    private EditText txtName, txtLastname, txtAddress, txtEmail,
            txtPassword, txtPassword_confirmation, txtAge, txtTrainingLevel;
    private Button singUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        txtName = findViewById(R.id.txtName);
        txtAddress = findViewById(R.id.txtDireccion);
        txtEmail = findViewById(R.id.txtSign_email);
        txtPassword = findViewById(R.id.txtSign_password);
        txtPassword_confirmation = findViewById(R.id.txtSign_password_again);
        txtAge = findViewById(R.id.txtEdad);
        singUp = findViewById(R.id.signup_button);

        singUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = txtName.getText().toString().trim();
                String address = txtAddress.getText().toString().trim();
                String email = txtEmail.getText().toString().trim();
                String password = txtPassword.getText().toString().trim();
                String password_confirmation = txtPassword_confirmation.getText().toString().trim();
                int age = Integer.parseInt(txtAge.getText().toString().trim());

                UserRegister apiService = UserRegisterApiAdapter.getApiService();
                Call<User> call = apiService.User(name, "Perez", age, email, password, password_confirmation, address, 1);

                call.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        if (response.isSuccessful() && response.body() != null){
                            String tokenInter = response.body().getName();
                            System.out.println("Token: "+tokenInter);
                        }
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        System.out.println("error asdsadasd:"+t.getCause());
                    }
                });


            }
        });
    }

    public void go_to_login(View view)
    {
        Intent GoBack=new Intent(RegisterActivity.this,MainActivity.class);
        startActivity(GoBack);
        finish();
    }

}