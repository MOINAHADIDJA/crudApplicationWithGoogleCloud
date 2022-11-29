package com.example.crudapp.http;

import com.example.crudapp.utils.NullOnEmptyConverterFactory;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitGenerator {

    private static Retrofit instance;

    private RetrofitGenerator(){

    }

    synchronized
    public static Retrofit getRetrofit(){
        if (instance==null){
            instance  = new Retrofit.Builder()
                    .baseUrl("https://miniprojet-369823.wn.r.appspot.com/api/")
                    .addConverterFactory(new NullOnEmptyConverterFactory())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return instance;
    }
}
