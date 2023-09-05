package com.bestdeveloper.movieproapp.viewModel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.bestdeveloper.movieproapp.model.Movie;
import com.bestdeveloper.movieproapp.model.MovieRepos;

import java.util.List;

public class ViewModel extends AndroidViewModel {
    private MovieRepos repository;

    public ViewModel(Application application){
        super(application);

        repository = new MovieRepos(application);
    }

    public LiveData<List<Movie>> getPopularMovies(){
        return repository.getMutableLiveData();
    }


}
