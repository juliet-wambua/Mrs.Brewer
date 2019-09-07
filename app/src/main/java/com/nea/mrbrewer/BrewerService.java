package com.nea.mrbrewer;

import okhttp3.Callback;
import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class BrewerService {
    public static void findBrewers(String[] beer, Callback callback){

        OkHttpClient client = new OkHttpClient.Builder()
                .build();


        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.TOKEN_BASE_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.TOKEN_BEER_QUERY_PARAMETER, beer);
        String url = urlBuilder.build ().toString ();

        Request request = new Request.Builder()
                .url(url)
                .header("Authorization", Constants.MY_TOKEN)
                .build();

        Call call = client.newCall ( request );
        call.enqueue(callback);

    }
}
