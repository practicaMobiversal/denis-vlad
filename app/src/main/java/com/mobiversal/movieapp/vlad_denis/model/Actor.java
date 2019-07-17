package com.mobiversal.movieapp.vlad_denis.model;

import androidx.room.ColumnInfo;

public class Actor {

    private int id;
    private String name;
    private String Imageview;


    public Actor(int id, String name, String imageview) {
        this.id = id;
        this.name = name;
        Imageview = imageview;

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
        return Imageview;
    }

    public void setImageview(String imageview) {
        Imageview = imageview;
    }


}

