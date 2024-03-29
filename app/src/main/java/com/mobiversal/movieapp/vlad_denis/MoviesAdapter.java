package com.mobiversal.movieapp.vlad_denis;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mobiversal.movieapp.vlad_denis.model.Movie;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MovieItemViewHolder> {
private List<Movie> movies;
private ItemClickListener listener;

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public MoviesAdapter(List<Movie> movies,ItemClickListener listener){
    this.movies = movies;
    this.listener = listener;
}

    @NonNull
    @Override
    public MovieItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.view_movie_item,parent, false);
        return new  MovieItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieItemViewHolder holder, int position) {
    Movie movie = this.movies.get(position);
    holder.onBind(movie);
    holder.itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            listener.onItemClick(movie);
        }
    });

    }

    @Override
    public int getItemCount() {

        return movies.size();
    }
}
