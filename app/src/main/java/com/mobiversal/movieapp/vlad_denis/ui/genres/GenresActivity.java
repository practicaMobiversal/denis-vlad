package com.mobiversal.movieapp.vlad_denis.ui.genres;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.media.tv.TvContract;
import android.os.Bundle;
import android.util.Log;
import android.widget.Adapter;

import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.mobiversal.movieapp.vlad_denis.Network.RequestManager;
import com.mobiversal.movieapp.vlad_denis.Network.response.ActorsResponse;
import com.mobiversal.movieapp.vlad_denis.Network.response.GenresResponse;
import com.mobiversal.movieapp.vlad_denis.ParentActivity;
import com.mobiversal.movieapp.vlad_denis.R;
import com.mobiversal.movieapp.vlad_denis.model.Actor;
import com.mobiversal.movieapp.vlad_denis.model.Genre;
import com.mobiversal.movieapp.vlad_denis.ui.actors.ActorsAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GenresActivity extends ParentActivity {

    private GenresAdapter genres;
    private RecyclerView rvGenres;
    private GenresAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genres2);
        rvGenres = findViewById(R.id.rv_actors);
        setupRecycleView();
        getGenres();
    }



    private void setupRecycleView(){
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(RecyclerView.VERTICAL);
        rvGenres.setLayoutManager(llm);

         adapter  = new GenresAdapter(new ArrayList<>());
        rvGenres.setAdapter(adapter);

    }

    private void getGenres() {
        Call<GenresResponse> request = RequestManager.getInstance().getGenres();
        request.enqueue(new Callback<GenresResponse>() {
            @Override
            public void onResponse(Call<GenresResponse> call, Response<GenresResponse> response) {


                List<Genre> genres = response.body().getGenres();
                if (genres != null) {
                    adapter.setGenres(genres);
                    adapter.notifyDataSetChanged();
                }
                for (Genre genre : genres) {
                    Log.d(Tag, genre.getName());

                }
                Log.d(Tag, "Get genres success" + response.body().getGenres().toString());
            }

            @Override
            public void onFailure(Call<GenresResponse> call, Throwable t) {
                Log.d(Tag, "Get genres failure:" + t.getMessage());
            }
        });
    }
}





