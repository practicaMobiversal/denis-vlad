package com.mobiversal.movieapp.vlad_denis;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.PagerAdapter;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;

import com.google.android.material.tabs.TabLayout;
import com.mobiversal.movieapp.vlad_denis.Network.RequestManager;
import com.mobiversal.movieapp.vlad_denis.Network.response.MoviesResponse;
import com.mobiversal.movieapp.vlad_denis.database.AppDataBase;
import com.mobiversal.movieapp.vlad_denis.model.Movie;
import com.mobiversal.movieapp.vlad_denis.ui.FirstFragment;
import com.mobiversal.movieapp.vlad_denis.ui.SecondFragment;

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
        splashScreenTransition();
        //getSupportFragmentManager().beginTransaction().add(R.id.llfrag, new WatchedFragment(), "");
        getMovies();
        getMoviesFromDataBase();
    }

    private void initClickListeners() {
        //findViewById(R.id.Favorites).setOnClickListener(new View.OnClickListener() {
        //  @Override
        //  public void onClick(View view) {
        //   openSavedMoviesScreen();
        // }
        //});

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

                AppDataBase.getInstance(MainActivity.this)
                        .movieDao()
                        .deleteAll();

                List<Movie> movies = response.body().getResults();

                for (Movie movie : movies) {
                    Log.d(TAG, movie.getTitle());
                    AppDataBase.getInstance(MainActivity.this)
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
        List<Movie> movies = AppDataBase.getInstance(this).movieDao().getAllMovies();
        for (Movie movie : movies) {
            Log.d(TAG, movie.getTitle());
        }
    }
    private void splashScreenTransition() {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), PreferencesActivity.class));
                finish();
            }

        }, 5000);
    }

}

