package com.mobiversal.movieapp.vlad_denis.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ImageUtils {

    public static void LoadImage(Context context, ImageView imageView, String url) {
        Glide.with(imageView).load(url).into(imageView);
    }
}
