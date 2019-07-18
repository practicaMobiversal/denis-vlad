package com.mobiversal.movieapp.vlad_denis.ui.genres;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mobiversal.movieapp.vlad_denis.R;
import com.mobiversal.movieapp.vlad_denis.model.Genre;

import java.util.List;

public class GenresAdapter extends RecyclerView.Adapter<GenresAdapter.GenreViewHolder>{

    List<Genre> genres;

    public GenresAdapter(List<Genre> genres) {
        this.genres = genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    @NonNull
    @Override
    public GenreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.view_genres_item, parent, false);
        return new GenreViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GenreViewHolder holder, int position) {
        holder.onBind(genres.get(position));
        getItemCount();
    }

    @Override
    public int getItemCount() {
        return genres.size();
    }


    class GenreViewHolder extends RecyclerView.ViewHolder {

        TextView genreTextView;
        CheckBox genreCheckBox;

        public GenreViewHolder(@NonNull View itemView) {
            super(itemView);

            genreTextView = itemView.findViewById(R.id.tv_gen);
            genreCheckBox = itemView.findViewById(R.id.checkBox);
        }


        public void onBind(Genre genre){
            genreTextView.setText(genre.getName());
        }
    }
}