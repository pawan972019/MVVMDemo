package com.example.mvvmdemo.dataBinding;

import android.content.Context;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.mvvmdemo.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class GlideDataBindingAdapter {

    @BindingAdapter("imageUrl")
    public static void setImageResource(CircleImageView circleImageView, String imageUrl){

        Context mContext = circleImageView.getContext();
        Glide.with(mContext)
                .load(imageUrl)
                .dontTransform()
                .placeholder(R.drawable.ic_launcher_foreground)
                .diskCacheStrategy(DiskCacheStrategy.DATA)
                .dontAnimate()
                .error(R.drawable.ic_launcher_background)
                .into(circleImageView);
    }
}
