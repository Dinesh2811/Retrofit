package com.dinesh.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
//    https://dummyjson.com/products/search?q=Laptop
//    https://jsonplaceholder.typicode.com/

    private static final String BASE_URL = "https://dummyjson.com/";
    private static Retrofit retrofit = null;

    public static Retrofit getRetrofit() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build();

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
//                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit;
    }
}
