package com.chatapp.twasol;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {
    @FormUrlEncoded
    @POST("api/fcm-token") // Adjust this endpoint to your server's endpoint
    Call<ResponseBody> sendFcmToken(@Field("token") String token);
}