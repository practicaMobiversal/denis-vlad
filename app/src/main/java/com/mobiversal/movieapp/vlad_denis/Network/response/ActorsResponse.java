package com.mobiversal.movieapp.vlad_denis.Network.response;

import com.google.gson.annotations.SerializedName;
import com.mobiversal.movieapp.vlad_denis.model.Actor;

import java.util.List;

public class ActorsResponse {

    @SerializedName("page")
    private int page;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List<Actor> getResults() {
        return results;
    }

    public void setResults(List<Actor> results) {
        this.results = results;
    }

    @SerializedName("total_results")
    private int totalResults;
    @SerializedName("total_pages")
    private int totalPages;
    @SerializedName("results")
    private List<Actor> results;

}
