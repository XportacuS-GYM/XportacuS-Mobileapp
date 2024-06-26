package com.example.xportacus.io;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface UserInfo {

    @GET("/api/infoUsuario")
    Call<User> User(
            @Header("Authorization") String authHeader,
            @Query("email") String email
    );
}
