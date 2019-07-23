package com.mobiversal.movieapp.vlad_denis.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.mobiversal.movieapp.vlad_denis.model.Actor;

import java.util.List;

@Dao
public interface ActorDao {


    @Query("SELECT * FROM actor")
    List<Actor> getAllActors();

    @Insert
    public long saveActor(Actor actor);

    @Query("DELETE FROM actor")
    public void deleteAll();
}
