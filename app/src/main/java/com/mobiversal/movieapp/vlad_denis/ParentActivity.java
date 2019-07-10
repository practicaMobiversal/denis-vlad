package com.mobiversal.movieapp.vlad_denis;


import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class ParentActivity extends AppCompatActivity {

   protected String Tag = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       Log.d(Tag,   "onCreate");
    }

    protected void onStart() {
        super.onStart();
        Log.d(Tag, "onStart");
    }

    protected void onResume() {
        super.onResume();
        Log.d(Tag, "onResume");
    }

    protected void onPause() {
        super.onPause();
        Log.d(Tag, "onPause");
    }

    protected void onStop() {
        super.onStop();
        Log.d(Tag, "onStop");
    }

    protected void onRestart() {
        super.onRestart();
        Log.d(Tag,"onRestart");
    }

    protected void onDestroy() {
        super.onDestroy();
        Log.d(Tag, "onDestroy");
    }
}




