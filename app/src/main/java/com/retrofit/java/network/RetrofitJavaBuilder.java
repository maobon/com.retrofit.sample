package com.retrofit.java.network;

import android.content.Context;

import java.io.File;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitJavaBuilder {

    private Retrofit mRetrofit;

    private static final String URL_BASE = "http://api.juheapi.com/japi/";

    public RetrofitJavaBuilder(Context context) {
        mRetrofit = new Retrofit.Builder()
                .client(getSimpleOkHttpClient(context)) // custom client
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public Retrofit getRetrofit() {
        return mRetrofit;
    }

    // 添加 网络请求 Log输出拦截器
    private OkHttpClient getSimpleOkHttpClient(Context context) {
        File okHttpCache = new File(context.getCacheDir(), "OkHttpCache");

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        return new OkHttpClient.Builder()
                .cache(new Cache(okHttpCache, 1024 * 1024))
                .addInterceptor(httpLoggingInterceptor)
                .build();
    }
}
