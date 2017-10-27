package com.example.charles.makelistview.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by charles on 2017. 10. 27..
 * Retrofit Api Client
 */

public class RetrofitApiClient {

    private static final String BASE_URL = "https://raw.githubusercontent.com/hasancse91/Android-CardView-RecyclerView/master/Related_Data/";

    private static Retrofit retrofit = null;

    private static Gson gson = new GsonBuilder()
            .setLenient()
            .create();

    private RetrofitApiClient() {}

    public static synchronized  Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit;
    }

}
