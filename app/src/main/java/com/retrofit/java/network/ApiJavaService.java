package com.retrofit.java.network;

import com.retrofit.java.model.BeanList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;


public interface ApiJavaService {

    @GET("toh")
    Call<BeanList> getRequestData(
            @Query("key") String apiKey,
            @Query("v") String apiVersion,
            @Query("month") int month,
            @Query("day") int day
    );

    @FormUrlEncoded
    @POST("toh")
    Call<BeanList> postRequestData(
            @Field("key") String key,
            @Field("v") String version,
            @Field("month") int month,
            @Field("day") int day
    );

    // Call<BeanList> postRequestData(@Body PostBody body); // JSON Format
}
