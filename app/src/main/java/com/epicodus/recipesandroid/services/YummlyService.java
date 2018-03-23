package com.epicodus.recipesandroid.services;

import com.epicodus.recipesandroid.Constants;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class YummlyService {

    public static void findRecipes(String yummlyQuery, Callback callback) {

        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.YUMMLY_BASE_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.YUMMLY_QUERY_PARAMETER, yummlyQuery);
        String url = urlBuilder.build().toString();

        Request request= new Request.Builder()
                .url(url)
                .header("X-Yummly-App-ID", Constants.YUMMLY_ID)
                .header("X-Yummly-App-Key", Constants.YUMMLY_KEY)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);

    }
}
