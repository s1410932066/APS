package com.example.aps.APIService;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitManager {
    public static RetrofitManager mInstance = new RetrofitManager();
    private APIService myAPIService;
    private RetrofitManager(){
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.0.203:8082/api/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        myAPIService = retrofit.create(APIService.class);
    }
    public static RetrofitManager getInstance(){
        return mInstance;
    }
    public APIService getAPI(){
        return myAPIService;
    }
}
