package com.example.movieapp.Service.Repository;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;

import com.example.movieapp.Service.Model.MovieModel;
import com.example.movieapp.Service.Model.Result;
import com.example.movieapp.Service.Network.ApiService;
import com.example.movieapp.Service.Network.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepository {

   private static MovieRepository instance;
   private static Context mcontext;
   private MovieModel movieModel;

   private List<Result> result;
   private MutableLiveData mutableLiveData;


    public static MovieRepository getInstance(Context context){

        if(instance == null){
            instance = new MovieRepository();
            mcontext = context;
        }
        return instance;
    }

    public MutableLiveData<List<Result>>getTopRatedMovieLists(){
        if(mutableLiveData == null){
            mutableLiveData = new MutableLiveData();
        }

        ApiService apiService = RetrofitInstance.getRetrofitInstance().create(ApiService.class);
       Call<MovieModel> call =  apiService.getTopRatedMovieList();
       call.enqueue(new Callback<MovieModel>() {
           @Override
           public void onResponse(Call<MovieModel> call, Response<MovieModel> response) {
               movieModel = response.body();
               result = movieModel.getResults();

               mutableLiveData.postValue(result);

           }

           @Override
           public void onFailure(Call<MovieModel> call, Throwable t) {

           }
       });
       return  mutableLiveData;
    }




}
