package com.retrofit.kotlin.retrofit

import com.retrofit.kotlin.model.BeanList
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiSampleService {

    @GET("toh")
    fun getRequestData(
            @Query("key") apiKey: String,
            @Query("v") apiVersion: String,
            @Query("month") month: Int,
            @Query("day") day: Int,
    ): Call<BeanList>

    companion object {
        fun create(): ApiSampleService {
            val retrofit = Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("http://api.juheapi.com/japi/")
                    .build()
            return retrofit.create(ApiSampleService::class.java)
        }
    }
}