package com.example.mvvmdemo.dataBinding

import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.mvvmdemo.R
import de.hdodenhof.circleimageview.CircleImageView

object GlideDataBindingAdapter {

    @BindingAdapter("imageUrl")
    fun setImageResource(circleImageView: CircleImageView, imageUrl: String?) {
        val mContext = circleImageView.context
        Glide.with(mContext)
            .load(imageUrl)
            .dontTransform()
            .placeholder(R.drawable.ic_launcher_foreground)
            .diskCacheStrategy(DiskCacheStrategy.DATA)
            .dontAnimate()
            .error(R.drawable.ic_launcher_background)
            .into(circleImageView)
    }
}