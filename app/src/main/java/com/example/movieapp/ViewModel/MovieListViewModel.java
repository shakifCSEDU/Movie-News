package com.example.movieapp.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.movieapp.Service.Model.Result;
import com.example.movieapp.Service.Repository.MovieRepository;



import java.util.List;

public class MovieListViewModel extends AndroidViewModel {

    MovieRepository movieRepository;



    public MovieListViewModel(Application application) {
        super(application);
        movieRepository = MovieRepository.getInstance(application);

    }
    public LiveData<List<Result>>getTopRateMovieLists(){
       return movieRepository.getTopRatedMovieLists();
    }
}
