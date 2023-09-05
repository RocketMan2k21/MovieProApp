package com.bestdeveloper.movieproapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.bestdeveloper.movieproapp.R;
import com.bestdeveloper.movieproapp.databinding.ActivityMovieBinding;
import com.bestdeveloper.movieproapp.model.Movie;

public class MovieActivity extends AppCompatActivity {
    private Movie movie;
    private ActivityMovieBinding movieBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        movieBinding = DataBindingUtil.setContentView(this, R.layout.activity_movie);

        Intent i = getIntent();


        if(i.hasExtra("movie")){
            movie = i.getParcelableExtra("movie");
            movieBinding.setMovie(movie);
            getSupportActionBar().setTitle(movie.getTitle());
        }


    }
}