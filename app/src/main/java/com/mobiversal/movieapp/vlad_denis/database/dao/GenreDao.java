package com.mobiversal.movieapp.vlad_denis.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.mobiversal.movieapp.vlad_denis.model.Actor;
import com.mobiversal.movieapp.vlad_denis.model.Genre;

import java.util.List;

@Dao
public interface GenreDao {

    @Query("SELECT * FROM genre")
    List<Genre> getAllGenre();

    @Insert
    public long saveGenre(Genre genre);
    @Query("DELETE FROM genre")
    public void deleteAll();









}
