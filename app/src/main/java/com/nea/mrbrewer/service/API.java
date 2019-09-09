package com.nea.mrbrewer.service;

import com.nea.mrbrewer.models.Bible;
import com.nea.mrbrewer.models.Verse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API {
    @GET("bible/")
    Call<Bible> getBible();

    @GET("verse/")
    Call<Verse> getVerse();
}
