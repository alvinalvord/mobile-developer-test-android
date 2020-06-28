package com.alvinalvord.myapplication.services;

import com.alvinalvord.myapplication.model.iTunesData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface iTunesService {

    @GET("/search?term=pop")
    Call<iTunesData> getPopSongs ();

}