package com.mobiversal.movieapp.vlad_denis.ui.actors;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.mobiversal.movieapp.vlad_denis.Network.RequestManager;
import com.mobiversal.movieapp.vlad_denis.Network.response.ActorsResponse;
import com.mobiversal.movieapp.vlad_denis.R;
import com.mobiversal.movieapp.vlad_denis.model.Actor;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActorsActivity extends AppCompatActivity {
private RecyclerView rvactor;
private String TAG = ActorsActivity.class.getSimpleName();
private ActorsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actors);
        rvactor = findViewById(R.id.rv_actors);
        getPopularP();
        setUpRecycleView();

    }

    private void setUpRecycleView() {
        LinearLayoutManager lln = new LinearLayoutManager(this);
        lln.setOrientation(RecyclerView.VERTICAL);
        rvactor.setLayoutManager(lln);
        adapter = new ActorsAdapter(new ArrayList<>());
        rvactor.setAdapter(adapter);


    }

    private void getPopularP() {
        Call<ActorsResponse> request = RequestManager.getInstance().getPopularActors();
        request.enqueue(new Callback<ActorsResponse>() {
            @Override
            public void onResponse(Call<ActorsResponse> call, Response<ActorsResponse> response) {


                List<Actor> actors = response.body().getResults();
                if (actors != null) {
                    adapter.setActors(actors);
                    adapter.notifyDataSetChanged();
                }
                for (Actor actor : actors) {
                    Log.d(TAG, actor.getName());

                }
                Log.d(TAG, "Get actors success" + response.body().getResults().toString());
            }

            @Override
            public void onFailure(Call<ActorsResponse> call, Throwable t) {
                Log.d(TAG, "Get actors failure:" + t.getMessage());
            }
        });
    }


}
