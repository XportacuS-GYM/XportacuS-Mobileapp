package com.example.xportacus.io;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface UserLogin {

    @FormUrlEncoded
    @POST("/api/login")
    Call<User> User(
            @Field("email") String email,
            @Field("password") String password
    );
}
