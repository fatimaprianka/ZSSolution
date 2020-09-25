package com.prianka.zssolution;

import com.google.gson.JsonObject;
import com.prianka.zssolution.model.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {

    //User sign in.......
    @FormUrlEncoded
    @POST("/api/v1/user")
    Call<LoginResponse> userSignIn(@Field("email")String userName,
                                   @Field("password")String password);
}
