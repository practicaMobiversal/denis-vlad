package com.mobiversal.movieapp.vlad_denis.Network.response;

import com.google.gson.annotations.SerializedName;
import com.mobiversal.movieapp.vlad_denis.model.Actor;
import com.mobiversal.movieapp.vlad_denis.model.Genre;

import java.util.List;

public class GenresResponse {

    @SerializedName("genres")
    private List<Genre> genres;

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }
}
