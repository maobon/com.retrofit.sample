package com.retrofit.kotlin.retrofit

import android.content.Context
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File

class RetrofitKotlinBuilder {

    private val urlBase = "http://api.juheapi.com/japi/"

    fun getRetrofitInstance(context: Context): Retrofit {
        return Retrofit.Builder()
                .client(getSimpleOkHttpClient(context))
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(urlBase)
                .build()
    }

    private fun getSimpleOkHttpClient(context: Context): OkHttpClient {
        return OkHttpClient.Builder()
                .cache(Cache(File(context.cacheDir, "OkHttpCache"), 1024 * 1024))
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build()
    }
}