package com.mobiversal.movieapp.vlad_denis.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "actor")

    public class Actor {

    @PrimaryKey
    @ColumnInfo(name = "id")
    private int id;
    @ColumnInfo(name = "name")
    private String name;
    @SerializedName("profile_path")
    @ColumnInfo(name = "imageview")
    private String imageview;
    @Ignore
    private boolean selected;


    public Actor(int id, String name, String imageview) {
        this.id = id;
        this.name = name;
        this.imageview = imageview;

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

    public String getImageview() {
        return imageview;
    }

    public void setImageview(String imageview) {
       this.imageview = imageview;
    }


    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}

