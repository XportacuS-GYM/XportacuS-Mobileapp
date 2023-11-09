package com.example.xportacus.io;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface UserRegister
{

    @FormUrlEncoded
    @PUT("/api/registro")
    Call<User> User(
            @Field("name") String name,
            @Field("lastname") String lastname,
            @Field("age") int age,
            @Field("email") String email,
            @Field("password") String password,
            @Field("password_confirmation") String password_confirmation,
            @Field("address") String address,
            @Field("trainingLevel") int trainingLevel
    );
}
