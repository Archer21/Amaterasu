package com.archer.amaterasu.io;

import com.archer.amaterasu.io.deserializer.SongDeserializer;
import com.archer.amaterasu.io.model.SongResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by archer on 20-12-16.
 */

public class ApiAdapter {
    private static ApiService API_SERVICE;

    public static ApiService getApiService () {
        if (API_SERVICE == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(ApiConstants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(buildGsonConverterFactory()))
                    .build();

            API_SERVICE = retrofit.create(ApiService.class);
        }

        return API_SERVICE;
    }

    private static Gson buildGsonConverterFactory () {
        Gson builder = new GsonBuilder()
            .registerTypeAdapter(SongResponse.class, new SongDeserializer())
            .create();

        return builder;
    }
}
































