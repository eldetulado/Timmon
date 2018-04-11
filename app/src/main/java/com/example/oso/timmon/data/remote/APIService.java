package com.example.oso.timmon.data.remote;

import com.example.oso.timmon.data.model.LoginR;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APIService {

    @POST("/kafeiapi/login")
    @FormUrlEncoded
    Call<LoginR> savePost(@Field("username") String username,
                          @Field("password") String password);
}