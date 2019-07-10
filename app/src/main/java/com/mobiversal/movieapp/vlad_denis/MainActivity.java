package com.mobiversal.movieapp.vlad_denis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends ParentActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initClickListeners();
    }
    private void initClickListeners() {
        findViewById(R.id.Favorites).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSavedMoviesScreen();
            }
        });

    }
    private void  openSavedMoviesScreen(){
            Intent intent = new Intent(this, SavedMoviesScreen.class);
            startActivity(intent);
        }
}


