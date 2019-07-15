package com.mobiversal.movieapp.vlad_denis.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.mobiversal.movieapp.vlad_denis.model.Keyword;

import java.util.List;
import java.util.stream.LongStream;

@Dao
public interface KeywordsDao {

    @Query("SELECT * FROM keyword")
    public List<Keyword> getAllKeywords();

    @Insert
    public void saveKeyword(Keyword keyword);
}

