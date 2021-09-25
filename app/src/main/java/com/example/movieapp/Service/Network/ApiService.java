package com.example.movieapp.Service.Network;

import com.example.movieapp.Service.Model.MovieModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("3/movie/top_rated?api_key=d1eebd4f23a015157533228e725f7ad1")
    Call<MovieModel>getTopRatedMovieList();





}
