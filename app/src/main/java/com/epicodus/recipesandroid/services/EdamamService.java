package com.epicodus.recipesandroid.services;

import com.epicodus.recipesandroid.Constants;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class EdamamService {

    public static void findRecipes(String query, Callback callback) {

        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.EDAMAM_BASE_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.EDAMAM_QUERY_PARAMETER, query);
        urlBuilder.addQueryParameter("app_id", Constants.EDAMAM_ID);
        urlBuilder.addQueryParameter("app_key", Constants.EDAMAM_KEY);
        String url = urlBuilder.build().toString();


        Request request= new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);

    }
}
