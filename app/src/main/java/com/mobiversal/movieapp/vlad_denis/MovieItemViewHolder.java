package com.mobiversal.movieapp.vlad_denis;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mobiversal.movieapp.vlad_denis.database.AppDataBase;
import com.mobiversal.movieapp.vlad_denis.model.Movie;
import com.mobiversal.movieapp.vlad_denis.utils.ImageUtils;

import static com.mobiversal.movieapp.vlad_denis.utils.Constants.BASE_IMAGE_URL;
import static com.mobiversal.movieapp.vlad_denis.utils.Constants.IMAGE_SIZE;

public class MovieItemViewHolder extends RecyclerView.ViewHolder {

    private TextView tvId;
    private TextView tvTitle;
    private ImageView imgView;
    Button fav;
    Button wat;
    Context context;

    public MovieItemViewHolder(@NonNull View itemView) {
        super(itemView);

        context = itemView.getContext();
        this.tvId = itemView.findViewById(R.id.tv_title);
        this.tvTitle = itemView.findViewById(R.id.tv_title);
        this.imgView = itemView.findViewById(R.id.iv_movie);
        this.fav = itemView.findViewById(R.id.btn_favorite_movie);
        this.wat = itemView.findViewById(R.id.btn_watched_movie);
    }

    public void onBind(Movie movie) {
        this.tvId.setText(String.format("#%d", movie.getId()));
        this.tvTitle.setText(movie.getTitle());
        ImageUtils.LoadImage(imgView.getContext(), imgView, BASE_IMAGE_URL + IMAGE_SIZE + movie.getImageUrl());
        getFavorite(movie);
        getWatched(movie);
    }

    public void getFavorite(Movie movie) {
        fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppDataBase.getInstance(context).movieDao().saveFavoriteMovie(movie);
            }
        });
    }


    public void getWatched(Movie movie) {
        fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppDataBase.getInstance(context).movieDao().saveWatchedMovies(movie);


            }

        });
    }
}