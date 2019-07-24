package com.mobiversal.movieapp.vlad_denis.ui.genres;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mobiversal.movieapp.vlad_denis.R;
import com.mobiversal.movieapp.vlad_denis.model.Actor;
import com.mobiversal.movieapp.vlad_denis.model.Genre;

import java.util.ArrayList;
import java.util.List;

public class GenresAdapter extends RecyclerView.Adapter<GenresAdapter.GenreViewHolder>{

    List<Genre> genres;
    public List<Genre> selectedGenres;

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public List<Genre> getSelectedGenres() {
        return selectedGenres;
    }

    public GenresAdapter(List<Genre> genres) {

        this.genres = genres;
        selectedGenres = new ArrayList<>();
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

        TextView genre;
        CheckBox genreCheckBox;


        public GenreViewHolder(@NonNull View itemView) {
            super(itemView);
            genre = itemView.findViewById(R.id.tv_gen);
            genreCheckBox = itemView.findViewById(R.id.checkBox4);

        }


        public void onBind(Genre genreItem) {
            genre.setText(genreItem.getName());
            genreCheckBox.setOnCheckedChangeListener(null);
            setCheckboxOnThick(genreItem);
            genreCheckBox.setChecked(genreItem.isSelected());


        }

        private void setCheckboxOnThick(Genre genreItem) {
            genreCheckBox.setOnCheckedChangeListener((buttonView, isChecked) -> {

                genre.setSelected(isChecked);
                if (isChecked) {
                    selectedGenres.add(genreItem);
                    Log.d("Genre ID", genreItem.getName());
                } else {

                    selectedGenres.remove(genreItem);
                    Log.d("Genres removed", genreItem.getName());
                }
            });
        }
    }
}