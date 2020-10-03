package com.retrofit.kotlin.retrofit

import com.retrofit.kotlin.model.BeanList
import retrofit2.Call
import retrofit2.http.*

interface ApiKotlinService {

    @GET("toh")
    fun getRequestData(
            @Query("key") apiKey: String,
            @Query("v") apiVersion: String,
            @Query("month") month: Int,
            @Query("day") day: Int,
    ): Call<BeanList>

    @FormUrlEncoded
    @POST("toh")
    fun postRequestData(
            @Field("key") key: String,
            @Field("v") version: String,
            @Field("month") month: Int,
            @Field("day") day: Int
    ): Call<BeanList>
}