package com.example.mvvmdemo.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmdemo.R
import com.example.mvvmdemo.databinding.ItemRowBinding
import com.example.mvvmdemo.models.NicePlaces
import java.util.*

class MainAdapter(context: Context, nicePlacesList: List<NicePlaces>) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    var nicePlacesList: List<NicePlaces> = ArrayList()
    var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemRowBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_row,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val nicePlaces = nicePlacesList[position]
        holder.itemRowBinding.nicePlace = nicePlaces
    }

    override fun getItemCount(): Int {
        return nicePlacesList.size
    }

    class ViewHolder(var itemRowBinding: ItemRowBinding) : RecyclerView.ViewHolder(itemRowBinding.root) {
        var recyclerBindingDataAdapter: MainAdapter? = null
    }

    init {
        this.nicePlacesList = nicePlacesList
        this.context = context
    }
}