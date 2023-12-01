package com.example.xportacus.io;

import android.os.AsyncTask;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Response;

public class ApiTaskUser extends AsyncTask<String, Void, User> {

    private TextView txtEmail;
    private TextView txtNombre;
    private TextView txtStatus;

    public ApiTaskUser(TextView txtEmail, TextView txtNombre, TextView txtStatus) {

        this.txtEmail = txtEmail;
        this.txtNombre = txtNombre;
        this.txtStatus = txtStatus;
    }
    @Override
    protected User doInBackground(String... emails) {
        String email = emails[0];

        // Realizar la solicitud a la API con Retrofit
        UserInfo apiService = UserInfoApiAdapter.getApiService();
        Call<User> call = apiService.User(email);

        try {
            Response<User> response = call.execute();
            if (response.isSuccessful()) {
                return response.body();
            } else {
                // Manejar el error de la solicitud
            }
        } catch (Exception e) {
            // Manejar la excepción
        }

        return null;
    }

    @Override
    protected void onPostExecute(User apiResponse) {
        super.onPostExecute(apiResponse);

        if (apiResponse != null) {
            // Actualizar la interfaz de usuario con la información de la API
            txtEmail.setText(apiResponse.getEmail());
            txtNombre.setText(apiResponse.getName());
            txtStatus.setText(apiResponse.getStatusSubscription());
        }
    }
}
