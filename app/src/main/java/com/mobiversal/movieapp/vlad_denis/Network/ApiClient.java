package com.mobiversal.movieapp.vlad_denis.Network;

import com.mobiversal.movieapp.vlad_denis.Network.response.ActorsResponse;
import com.mobiversal.movieapp.vlad_denis.Network.response.GenresResponse;
import com.mobiversal.movieapp.vlad_denis.Network.response.MoviesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiClient {

    @GET("movie/top_rated")
    Call<MoviesResponse> getTopRatedMovies(@Query("api_key") String apiKey);

    @GET("person/popular")
    Call<ActorsResponse> getPopularActors(@Query("api_key") String apiKey);

    @GET("genre/movie/list")
    Call<GenresResponse> getGenres(@Query("api_key") String apiKey);

    @GET("discover/movie")
    Call<MoviesResponse>getDiscoveredMovies(@Query("api_key")String apikey, @Query("with_cast") String cast, @Query("with_genres")String genres);

    @GET("search/movie")
    Call<MoviesResponse>getSearchMovies(@Query("api_key") String apiKey, @Query("query")String query);

}
