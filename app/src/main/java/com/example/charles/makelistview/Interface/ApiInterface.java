package com.example.charles.makelistview.Interface;

import com.example.charles.makelistview.model.JsonData;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by charles on 2017. 10. 27..
 * Api Interface
 */

public interface ApiInterface {

    @GET("data.json")
    Call<JsonData> apiCall();

}
