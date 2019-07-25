package com.mobiversal.movieapp.vlad_denis.ui;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.mobiversal.movieapp.vlad_denis.R;
import com.mobiversal.movieapp.vlad_denis.ui.movies.main.SectionsPagerAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends Fragment {


    public SecondFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(getContext(), getChildFragmentManager());
        ViewPager viewPager = view.findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = view.findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
    }
}
