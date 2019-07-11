package com.mobiversal.movieapp.vlad_denis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.mobiversal.movieapp.vlad_denis.Network.RequestManager;
import com.mobiversal.movieapp.vlad_denis.Network.response.MoviesResponse;
import com.mobiversal.movieapp.vlad_denis.database.ApDataBase;
import com.mobiversal.movieapp.vlad_denis.model.Movie;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends ParentActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initClickListeners();

        getSupportFragmentManager().beginTransaction().add(R.id.llfrag, new WatchedFragment(), "");
        //getMovies();
        getMoviesFromDataBase();
    }

    private void initClickListeners() {
        findViewById(R.id.Favorites).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSavedMoviesScreen();
            }
        });

    }

    private void openSavedMoviesScreen() {
        Intent intent = new Intent(this, SavedMoviesScreen.class);
        startActivity(intent);
    }

    private void getMovies() {

        Call<MoviesResponse> request = RequestManager.getInstance().getTopRatedMovies();
        request.enqueue(new Callback<MoviesResponse>() {
            @Override
            public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {
                List<Movie> movies = response.body().getResults();

                for (Movie movie : movies) {
                    Log.d(TAG, movie.getTitle());
                    ApDataBase.getInstance(MainActivity.this)
                            .movieDao()
                            .saveMovie(movie);
                }
                Log.d(TAG, "Get movies success: " + response.body().getResults().toString());
            }

            @Override
            public void onFailure(Call<MoviesResponse> call, Throwable t) {
                Log.d(TAG, "Get movies failure:" + t.getMessage());
            }


        });
    }
    private void getMoviesFromDataBase() {
        List<Movie> movies = ApDataBase.getInstance(this).movieDao().getAllMovies();
        for (Movie movie : movies) {
            Log.d(TAG, movie.getTitle());
        }
    }
}



