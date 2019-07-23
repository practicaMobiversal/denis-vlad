package com.mobiversal.movieapp.vlad_denis.ui.actors;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mobiversal.movieapp.vlad_denis.R;
import com.mobiversal.movieapp.vlad_denis.model.Actor;
import com.mobiversal.movieapp.vlad_denis.utils.ImageUtils;
import com.mobiversal.movieapp.vlad_denis.R;
import com.mobiversal.movieapp.vlad_denis.model.Actor;
import com.mobiversal.movieapp.vlad_denis.utils.ImageUtils;

import java.util.ArrayList;
import java.util.List;

import static com.mobiversal.movieapp.vlad_denis.utils.Constants.BASE_IMAGE_URL;
import static com.mobiversal.movieapp.vlad_denis.utils.Constants.IMAGE_SIZE;

public class ActorsAdapter extends RecyclerView.Adapter<ActorsAdapter.ActorViewHolder>{

    List<Actor> actors;
    List<Actor> actorsave = new ArrayList<>();

    public ActorsAdapter(List<Actor> actors) {
        this.actors = actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    @NonNull
    @Override
    public ActorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.view_actors_item, parent, false);
        return new ActorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ActorViewHolder holder, int position) {
        holder.onBind(actors.get(position));
    }

    @Override
    public int getItemCount() {
        return actors.size();
    }

    public List<Actor> getSelectedActors() {
        return actorsave;
    }


    class ActorViewHolder extends RecyclerView.ViewHolder {

        ImageView actorImageView;
        TextView actorTextView;
        CheckBox actorCheckBox;

        public ActorViewHolder(@NonNull View itemView) {
            super(itemView);

            actorImageView = itemView.findViewById(R.id.iv_id);
            actorTextView = itemView.findViewById(R.id.tv_name);
            actorCheckBox = itemView.findViewById(R.id.checkBox);
        }


        public void onBind(Actor actor){
            actorTextView.setText(actor.getName());
            ImageUtils.LoadImage(actorImageView.getContext(), actorImageView, BASE_IMAGE_URL + IMAGE_SIZE + actor.getImageview());
            actorCheckBox.setOnCheckedChangeListener(null);
            actorCheckBox.setChecked(actor.isSelected());
            checkListener(actor);
        }


        private void checkListener(Actor actor) {
            actorCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    // TODO Auto-generated method stub

                    if (isChecked) {
                        actorsave.add(actor);
                        Log.d("Actor checked!", actor.getName());
                    } else {
                        actorsave.remove(actor);
                        Log.d("Actor unchecked!", actor.getName());
                    }
                    actor.setSelected(isChecked);

                }

            });
        }

    }
}