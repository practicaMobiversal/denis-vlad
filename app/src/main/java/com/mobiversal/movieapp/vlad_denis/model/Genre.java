package com.mobiversal.movieapp.vlad_denis.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "genre")
public class Genre {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="id")
    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;

    @Ignore
    private boolean selected;

    public Genre(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}