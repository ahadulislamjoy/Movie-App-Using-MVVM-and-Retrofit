package com.example.movieapp.Service.Network;

import com.example.movieapp.Service.Model.MovieModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiServices {
    @GET("3/movie/top_rated?api_key=78b4b1108912ba94280daa82034c68ff")
    Call<MovieModel> getTopRatedMovieList();
}
