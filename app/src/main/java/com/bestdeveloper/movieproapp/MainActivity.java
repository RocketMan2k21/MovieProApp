package com.bestdeveloper.movieproapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Configuration;
import android.os.Bundle;

import com.bestdeveloper.movieproapp.adapter.MovieAdapter;
import com.bestdeveloper.movieproapp.databinding.ActivityMainBinding;
import com.bestdeveloper.movieproapp.model.Movie;
import com.bestdeveloper.movieproapp.viewModel.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mainBinding;
    private ViewModel movieViewModel;
    private MovieAdapter movieAdapter;

    private ArrayList<Movie> movieArrayList;

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Data
        movieViewModel = new ViewModelProvider(this).get(ViewModel.class);

        //Binding
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        getPopularMovies();




    }

    private void getPopularMovies() {
        movieViewModel.getPopularMovies().observe(this, new Observer<List<Movie>>() {
            @Override
            public void onChanged(List<Movie> moviesFromLiveData) {
                movieArrayList = (ArrayList<Movie>) moviesFromLiveData;
                ShowOnRecycleView();
            }
        });
    }

    private void ShowOnRecycleView() {

        recyclerView = mainBinding.rvMovies;
        movieAdapter = new MovieAdapter(movieArrayList, this);

        if(this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        }else{
            recyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        }

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(movieAdapter);
        movieAdapter.notifyDataSetChanged();
    }


}