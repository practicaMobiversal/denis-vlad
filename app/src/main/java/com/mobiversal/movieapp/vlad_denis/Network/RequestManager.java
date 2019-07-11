package com.mobiversal.movieapp.vlad_denis.Network;

import com.mobiversal.movieapp.vlad_denis.Network.response.MoviesResponse;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RequestManager {

            private static final String BASE_URL = "https://api.themoviedb.org/3/";
            private static final String API_KEY = "2f0eb07d4a17d6d68160dace69aa0ae4";

            private static RequestManager instance;

            private ApiClient apiClient;

            private RequestManager() {
                OkHttpClient okHttpClient = new OkHttpClient(). newBuilder()
                        .build();

                Retrofit retrofit = new Retrofit.Builder()
                        .client(okHttpClient)
                        .addConverterFactory(GsonConverterFactory.create())
                        .baseUrl(BASE_URL)
                        .build();

                apiClient = retrofit.create(ApiClient.class);
            }

            public static RequestManager getInstance() {
                if (instance == null) {
                    instance = new RequestManager();
                }
                return instance;
            }
            public Call<MoviesResponse> getTopRatedMovies() {
                return apiClient.getTopRatedMovies(API_KEY);
            }


}
