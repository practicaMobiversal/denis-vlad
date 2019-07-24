package com.mobiversal.movieapp.vlad_denis.ui;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobiversal.movieapp.vlad_denis.MoviesAdapter;
import com.mobiversal.movieapp.vlad_denis.MoviesLoadThread;
import com.mobiversal.movieapp.vlad_denis.Network.ApiClient;
import com.mobiversal.movieapp.vlad_denis.Network.RequestManager;
import com.mobiversal.movieapp.vlad_denis.Network.response.ActorsResponse;
import com.mobiversal.movieapp.vlad_denis.Network.response.MoviesResponse;
import com.mobiversal.movieapp.vlad_denis.R;
import com.mobiversal.movieapp.vlad_denis.database.AppDataBase;
import com.mobiversal.movieapp.vlad_denis.model.Actor;
import com.mobiversal.movieapp.vlad_denis.model.Genre;
import com.mobiversal.movieapp.vlad_denis.model.Movie;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {


    MoviesAdapter moviesAdapter;
    List<Movie> movies;
  private   RecyclerView rvMovies;

    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.movies = new ArrayList<>();
        this.rvMovies = view.findViewById(R.id.rv_movies);
        this.moviesAdapter = new MoviesAdapter(movies);
        movies = new ArrayList<>();

        setupRecycleView();
        getMovieList();


    }




    private void setupRecycleView() {
        LinearLayoutManager lln = new LinearLayoutManager(getContext());
        lln.setOrientation(RecyclerView.VERTICAL);
        rvMovies.setLayoutManager(lln);
        rvMovies.setAdapter(moviesAdapter);

    }

    public String getActorsFromDb() {
        List<Actor> chosenActors = AppDataBase.getInstance(getContext()).actorDao().getAllActors();
        String actors = "";
        for (int i = 0; i<chosenActors.size();i++){
            actors += String.valueOf(chosenActors.get(i).getId())+"|";
        }

        return actors;
    }

    public String getGenresFromDb() {
        List<Genre> chosenGenres = AppDataBase.getInstance(getContext()).genreDao().getAllGenre();
        String genres = "";
        for (int i = 0; i<chosenGenres.size();i++){
            genres += String.valueOf(chosenGenres.get(i).getId())+"|";
        }
        return genres;
    }


    private void getMovieList() {
        Call<MoviesResponse> request = RequestManager.getInstance().getDiscoveredMovies(getActorsFromDb(),getGenresFromDb());
        request.enqueue(new Callback<MoviesResponse>() {
            @Override
            public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {


               List<Movie> movies = response.body().getResults();
                if (movies != null) {
                    moviesAdapter.setMovies(movies);
                    moviesAdapter.notifyDataSetChanged();
                }
                for (Movie movie : movies) {
                    Log.d("MovieList", movie.getTitle());

                }
                Log.d("MovieList", "Get actors success" + response.body().getResults().toString());
            }

            @Override
            public void onFailure(Call<MoviesResponse> call, Throwable t) {
                Log.d("MovieList", "Get actors failure:" + t.getMessage());
            }
        });
    }







}
