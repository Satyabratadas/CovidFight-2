package com.example.covidfight;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Api {
    @POST("register/")
    Call<ResponseBody> register(@Body RegisterRequest registerRequest);
    @POST("login/")
    Call<User> login(@Body LoginRequest loginRequest);
}
