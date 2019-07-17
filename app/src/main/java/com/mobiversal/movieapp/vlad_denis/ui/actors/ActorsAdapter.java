package com.mobiversal.movieapp.vlad_denis.ui.actors;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mobiversal.movieapp.vlad_denis.R;
import com.mobiversal.movieapp.vlad_denis.model.Actor;
import com.mobiversal.movieapp.vlad_denis.utils.ImageUtils;

import java.util.List;

public class ActorsAdapter extends RecyclerView.Adapter<ActorsAdapter.ActorViewHolder> {

List<Actor> actors;


    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public ActorsAdapter(List<Actor> actors) {
        this.actors = actors;
    }

    @NonNull
    @Override
    public ActorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.view_actors_item,parent, false);
        return new ActorViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ActorViewHolder holder, int position) {


        holder.show(actors.get(position));


    }


    @Override
    public int getItemCount() {
        return actors.size();
    }

    class ActorViewHolder extends RecyclerView.ViewHolder {

     ImageView imageViewActor;
     TextView TextViewActor;
     CheckBox CheckBoxActor;

        public ActorViewHolder(@NonNull View itemView) {
            super(itemView);

                    imageViewActor = itemView.findViewById(R.id.iv_id);
                    TextViewActor = itemView.findViewById(R.id.iv_name);
                    CheckBoxActor = itemView.findViewById(R.id.checkBox);
        }

        public void show(Actor actor) {
            TextViewActor.setText(actor.getName());
            ImageUtils.LoadImage(imageViewActor.getContext(),imageViewActor,actor.getImageview());










        }



    }



















}
