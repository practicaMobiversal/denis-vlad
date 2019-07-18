package com.mobiversal.movieapp.vlad_denis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.mobiversal.movieapp.vlad_denis.database.AppDataBase;
import com.mobiversal.movieapp.vlad_denis.model.Actor;
import com.mobiversal.movieapp.vlad_denis.model.Keyword;
import com.mobiversal.movieapp.vlad_denis.ui.DrawerActivity;
import com.mobiversal.movieapp.vlad_denis.ui.actors.ActorsActivity;
import com.mobiversal.movieapp.vlad_denis.ui.actors.ActorsAdapter;
import com.mobiversal.movieapp.vlad_denis.ui.genres.GenresActivity;

public class PreferencesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);
        DrawerActivityOnClick();
        openActors();
        openGenres();

    }

    private String getKeywords() {

        EditText keywords = findViewById(R.id.keywords);
        String textKeywords = keywords.getEditableText().toString();
        return textKeywords;
    }

    private void initClickListeners() {
        findViewById(R.id.save_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveKeywords(getKeywords());
            }
        });


    }

    private void openActors() {
        findViewById(R.id.btn_actors).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PreferencesActivity.this, ActorsActivity.class);
            startActivity(intent);
            }

            });
        };

    private void openGenres() {
        findViewById(R.id.genres).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PreferencesActivity.this, GenresActivity.class);
                startActivity(intent);
            }

        });
    };


    private void saveKeywords(String name) {
        Keyword keywordEmpty = new Keyword(name);
        AppDataBase.getInstance(PreferencesActivity.this).keywordsDao().saveKeyword(keywordEmpty);
        Log.d(PreferencesActivity.class.getSimpleName(), name);
    }

//    private void saveOnClick() {
//        findViewById(R.id.save_btn).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                //
//                //TODO: Move this outside of save function
//                saveKeywords(getKeywords());
//                Intent intent = new Intent(PreferencesActivity.this, MoviesActivity.class);
//                startActivity(intent);
//            }
//        });
//    }

    private void DrawerActivityOnClick() {
        findViewById(R.id.save_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(PreferencesActivity.this, DrawerActivity.class);
                startActivity(intent);
            }
        });
    }
}
