package com.mobiversal.movieapp.vlad_denis;

import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mobiversal.movieapp.vlad_denis.database.AppDataBase;
import com.mobiversal.movieapp.vlad_denis.model.Movie;

import java.util.List;

public class MoviesActivity extends ParentActivity {

    private RecyclerView rvMovies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);

        this.rvMovies = findViewById(R.id.rv_movies);
        setupRecycleView();
    }

    private void setupRecycleView() {
        LinearLayoutManager lln = new LinearLayoutManager(this);
        lln.setOrientation(RecyclerView.VERTICAL);

        rvMovies.setLayoutManager(lln);

        new MoviesLoadThread(this) {
            @Override
            public void onDone(@Nullable List<Movie> movies) {
                MoviesAdapter moviesAdapter = new MoviesAdapter(movies);
                rvMovies.setAdapter(moviesAdapter);
            }
        }.execute(null,null,null);

        List<Movie> movies = AppDataBase.getInstance(this).movieDao().getAllMovies();

        MoviesAdapter moviesAdapter = new MoviesAdapter(movies);
        rvMovies.setAdapter(moviesAdapter);
    }
}
