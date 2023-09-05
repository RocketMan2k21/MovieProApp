package com.bestdeveloper.movieproapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.bestdeveloper.movieproapp.R;
import com.bestdeveloper.movieproapp.databinding.ActivityMovieBinding;
import com.bestdeveloper.movieproapp.databinding.MovieListItemLayoutBinding;
import com.bestdeveloper.movieproapp.model.Movie;
import com.bestdeveloper.movieproapp.view.MovieActivity;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private ArrayList<Movie> movies;
    private Context context;

    public MovieAdapter(ArrayList<Movie> movies, Context context) {
        this.movies = movies;
        this.context = context;
    }

    class MovieViewHolder extends RecyclerView.ViewHolder {
        private MovieListItemLayoutBinding movieBinding;


        public MovieViewHolder(MovieListItemLayoutBinding movieBinding) {
            super(movieBinding.getRoot());
            this.movieBinding = movieBinding;

            movieBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();

                    if(pos != RecyclerView.NO_POSITION){
                        Movie selectedMovie = movies.get(pos);

                        Intent i = new Intent(context, MovieActivity.class);
                        i.putExtra("movie", selectedMovie);
                        context.startActivity(i);
                    }
                }
            });
        }
    }


    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MovieListItemLayoutBinding movieBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.movie_list_item_layout,
                parent,
                false
        );

        return new MovieViewHolder(movieBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        final Movie movie = movies.get(position);
        holder.movieBinding.setMovie(movie);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

}
