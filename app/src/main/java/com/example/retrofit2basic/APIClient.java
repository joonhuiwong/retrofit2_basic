package com.example.retrofit2basic;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {

    //public static String URL = "https://reqres.in";

    private static Retrofit retrofit = null;

    public static Retrofit getClient(String baseUrl) {

        // Interceptors are mechanisms in OkHttp that can monitor, rewrite and retry calls.
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        // Create OkHttpClient and hook Interceptor
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();

        // Create the Retrofit Client
        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        //TODO: Should this be a singleton? Or use the object calling this should be a singleton only calling this once?
        return retrofit;
    }
}
