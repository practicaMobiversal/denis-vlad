package com.mobiversal.movieapp.vlad_denis.ui.movies.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mobiversal.movieapp.vlad_denis.ItemClickListener;
import com.mobiversal.movieapp.vlad_denis.R;
import com.mobiversal.movieapp.vlad_denis.model.Movie;
import com.mobiversal.movieapp.vlad_denis.utils.ImageUtils;

import java.util.List;

import static com.mobiversal.movieapp.vlad_denis.utils.Constants.BASE_IMAGE_URL;
import static com.mobiversal.movieapp.vlad_denis.utils.Constants.IMAGE_SIZE;

public class TabMovieAdapter extends RecyclerView.Adapter<TabMovieAdapter.SavedMovieItemViewHolder> {

    private List<Movie> movies;
    private ItemClickListener listener;

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public TabMovieAdapter(List<Movie> movies,ItemClickListener listener){
        this.movies = movies;
        this.listener = listener;
    }

    @NonNull
    @Override
    public SavedMovieItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.view_saved_movie_item,parent, false);
        return new SavedMovieItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SavedMovieItemViewHolder holder, int position) {
        Movie movie = this.movies.get(position);
        holder.onBind(movie);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClick(movie);
            }
        });

    }

    @Override
    public int getItemCount() {

        return movies.size();
    }

    public class SavedMovieItemViewHolder extends RecyclerView.ViewHolder {

        private TextView tvId;
        private TextView tvTitle;
        private ImageView imgView;


        public SavedMovieItemViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tvId = itemView.findViewById(R.id.tv_title);
            this.tvTitle = itemView.findViewById(R.id.tv_title);
            this.imgView = itemView.findViewById(R.id.iv_movie);
        }

        public void onBind(Movie movie){
            this.tvId.setText(String.format("#%d", movie.getId()));
            this.tvTitle.setText(movie.getTitle());
            ImageUtils.LoadImage(imgView.getContext(), imgView, BASE_IMAGE_URL + IMAGE_SIZE + movie.getImageUrl());
        }
    }

}
