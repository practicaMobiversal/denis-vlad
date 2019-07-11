package com.mobiversal.movieapp.vlad_denis.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.mobiversal.movieapp.vlad_denis.database.dao.MovieDao;
import com.mobiversal.movieapp.vlad_denis.model.Movie;

@Database(entities =  {Movie.class}, version = 1)
public abstract class ApDataBase extends RoomDatabase {

    private static ApDataBase instance;
public abstract MovieDao movieDao();
    public static ApDataBase getInstance(Context context){
        if(instance == null) {
            return Room.databaseBuilder(context, ApDataBase.class,  "app_database")
            .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
}