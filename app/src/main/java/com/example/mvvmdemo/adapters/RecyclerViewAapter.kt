package com.example.mvvmdemo.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.mvvmdemo.R
import com.example.mvvmdemo.models.NicePlaces
import de.hdodenhof.circleimageview.CircleImageView
import java.util.*

class RecyclerViewAapter(var mContext: Context, nicePlacesList: MutableList<NicePlaces>?) : RecyclerView.Adapter<RecyclerViewAapter.ViewHolder>() {

    var nicePlaces: MutableList<NicePlaces> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyeler_view_adapter_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val nicePlace = nicePlaces[position]

        holder.placeName.text = nicePlace.title

        Glide.with(mContext)
            .load(nicePlace.imageUrl)
            .dontTransform()
            .placeholder(R.drawable.ic_launcher_foreground)
            .diskCacheStrategy(DiskCacheStrategy.DATA)
            .dontAnimate()
            .error(R.drawable.ic_launcher_background)
            .into(holder.image_view_thumb)
    }

    override fun getItemCount(): Int {
        return nicePlaces.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var placeName: TextView = itemView.findViewById(R.id.place_name)
        var image_view_thumb: CircleImageView = itemView.findViewById(R.id.image_view_thumb)
    }

    init {
        nicePlaces = nicePlacesList!!
    }
}