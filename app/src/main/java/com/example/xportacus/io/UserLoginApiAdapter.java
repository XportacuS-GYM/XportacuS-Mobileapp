package com.example.xportacus.io;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserLoginApiAdapter {
    private static UserLogin API_SERVICE;

    /**
     * Localhost IP for AVD emulators: 10.0.2.2
     */
    private static final String BASE_URL = "http://192.168.43.150/api/";

    public static UserLogin getApiService() {
        // Creamos un interceptor y le indicamos el log level a usar
        final HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        // Asociamos el interceptor a las peticiones
        final OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        if (API_SERVICE == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build()) // <-- set log level
                    .build();

            API_SERVICE = retrofit.create(UserLogin.class);
        }

        return API_SERVICE;
    }

}
