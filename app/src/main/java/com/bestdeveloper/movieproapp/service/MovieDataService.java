package com.bestdeveloper.movieproapp.service;

import com.bestdeveloper.movieproapp.model.Result;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieDataService {
    // Base URL
    //https://api.themoviedb.org/3
    // End Point URL
    // movie/popular?api_key=d4b1bbe1d17cf2ace1826e4f4c0b4b2b
    @GET("movie/popular")
    Call<Result> getPopularMovies(@Query("api_key") String key); // if url contains '?' character, therefore url had Query
}
