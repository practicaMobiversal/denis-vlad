package com.mobiversal.movieapp.vlad_denis.ui.actors;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.mobiversal.movieapp.vlad_denis.R;
import com.mobiversal.movieapp.vlad_denis.model.Actor;

import java.util.ArrayList;
import java.util.List;

public class ActorsActivity extends AppCompatActivity {
private RecyclerView rvactor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actors);
        rvactor = findViewById(R.id.rv_actors);
        setUpRecycleView();

    }

    private void setUpRecycleView() {
        LinearLayoutManager lln = new LinearLayoutManager(this);
        lln.setOrientation(RecyclerView.VERTICAL);
        ActorsAdapter adapter = new ActorsAdapter(getDumyList());
        rvactor.setAdapter(adapter);
        rvactor.setLayoutManager(lln);



    }


    private List<Actor> getDumyList() {
        List<Actor> dumy = new ArrayList<>();


        dumy.add(new Actor( 1, "Vin Diesel", "https://vignette.wikia.nocookie.net/thenecromancer/images/a/a3/Vin_Diesel.jpg/revision/latest?cb=20190324170624"));
        dumy.add(new Actor(1, "Paul Walker", "https://s1.r29static.com//bin/entry/935/720x864,85/2003943/image.webp"));
        dumy.add(new Actor(1, "Smeagol", "https://i.pinimg.com/originals/37/32/4c/37324c67e85bbeeca006097673304a5d.jpg"));
                return dumy;
    }
}
