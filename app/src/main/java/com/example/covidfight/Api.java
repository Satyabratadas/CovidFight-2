package com.example.covidfight;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Api {
    @POST("api/register/")
    @FormUrlEncoded
    Call<ResponseBody> register(
            @Field("username") String username,
            @Field("password") String passward,
            @Field("email") String email
    );
}
