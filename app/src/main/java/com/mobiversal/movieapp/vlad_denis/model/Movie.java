package com.mobiversal.movieapp.vlad_denis.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@Entity(tableName = "movie")
public class Movie {
     @PrimaryKey
     @ColumnInfo(name = "id")
    private long id;

    @SerializedName("title")
    @ColumnInfo(name = "title")
    private String title;
    @ColumnInfo(name = "image")
    @SerializedName("poster_path")
    private String imageUrl;


    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
