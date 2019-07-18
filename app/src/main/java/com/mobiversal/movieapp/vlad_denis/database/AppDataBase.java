package com.mobiversal.movieapp.vlad_denis.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.mobiversal.movieapp.vlad_denis.database.dao.ActorDao;
import com.mobiversal.movieapp.vlad_denis.database.dao.GenreDao;
import com.mobiversal.movieapp.vlad_denis.database.dao.KeywordsDao;
import com.mobiversal.movieapp.vlad_denis.database.dao.MovieDao;
import com.mobiversal.movieapp.vlad_denis.model.Actor;
import com.mobiversal.movieapp.vlad_denis.model.Genre;
import com.mobiversal.movieapp.vlad_denis.model.Keyword;
import com.mobiversal.movieapp.vlad_denis.model.Movie;

@Database(entities = {Movie.class, Keyword.class, Genre.class, Actor.class}, version = 2, exportSchema = false)
public abstract class AppDataBase extends RoomDatabase {

    private static AppDataBase instance;

    public abstract MovieDao movieDao();
    public abstract KeywordsDao keywordsDao();
    public abstract ActorDao actorDao();
    public abstract GenreDao genreDao();

    public static AppDataBase getInstance(Context context) {
        if (instance == null) {
            return Room.databaseBuilder(context, AppDataBase.class, "app_database")
                    .allowMainThreadQueries().fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}