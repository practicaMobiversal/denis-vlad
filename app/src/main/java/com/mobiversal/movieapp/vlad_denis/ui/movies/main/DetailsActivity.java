package com.mobiversal.movieapp.vlad_denis.ui.movies.main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.mobiversal.movieapp.vlad_denis.R;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_detail_activity);
        String sessionId = getIntent().getStringExtra("EXTRA_SESSION_ID");

    }
}
