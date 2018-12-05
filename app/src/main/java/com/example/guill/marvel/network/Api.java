package com.example.guill.marvel.network;

import com.example.guill.marvel.model.Hero;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    @GET("marvel")
    Call<List<Hero>> getHeroes();
}
