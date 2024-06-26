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

    public String email;

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
                            String token = response.body().getToken();
                            User user = response.body();
                            System.out.println(user.getName());
                            String email = user.getEmail();
                            String name=user.getName();
                            String direccion=user.getAddress();
                            int edad=user.getAge();
                            String statussub=user.getStatusSubscription();
                            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                            intent.putExtra("email", email);
                            intent.putExtra("name",name);
                            intent.putExtra("direccion",direccion);
                            intent.putExtra("edad",edad);
                            intent.putExtra("estatussub",statussub);
                            intent.putExtra("token",token);
                            startActivity(intent);
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
        Intent register=new Intent(MainActivity.this, RegisterActivity.class);
        startActivity(register);
        finish();
    }
}