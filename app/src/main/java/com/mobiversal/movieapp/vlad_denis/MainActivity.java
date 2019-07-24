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



        splashScreenTransition();


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

