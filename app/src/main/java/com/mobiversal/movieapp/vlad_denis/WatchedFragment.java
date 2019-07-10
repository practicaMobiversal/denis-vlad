package com.mobiversal.movieapp.vlad_denis;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link WatchedFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link WatchedFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WatchedFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_watched, container, false);
    }


}
