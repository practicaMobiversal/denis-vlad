package com.mobiversal.movieapp.vlad_denis.database.dao;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.mobiversal.movieapp.vlad_denis.model.Movie;

import java.util.List;

@Dao
public interface MovieDao {

    @Query("SELECT * FROM movie")
    List<Movie> getAllMovies();

    @Insert
      public long saveMovie(Movie movie);
      @Query("DELETE FROM movie")
      public void deleteAll();

    }
