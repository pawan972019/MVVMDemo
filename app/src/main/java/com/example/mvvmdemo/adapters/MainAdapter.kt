package com.example.mvvmdemo.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmdemo.R
import com.example.mvvmdemo.activity.FruitActivity
import com.example.mvvmdemo.activity.RoomDBActivity
import com.example.mvvmdemo.databinding.ItemRowBinding
import com.example.mvvmdemo.models.AtcivityListModel
import java.util.*

class MainAdapter(context: Context, atcivityListModelList: List<AtcivityListModel>) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    var atcivityListModelList: List<AtcivityListModel> = ArrayList()
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

        val nicePlaces = atcivityListModelList[position]

        holder.itemRowBinding.nicePlace = nicePlaces

        holder.itemRowBinding.activityCardView.setOnClickListener {

            if(position == 0){
                context.startActivity(Intent(context, FruitActivity::class.java))
            }else if(position == 1){
                context.startActivity(Intent(context, RoomDBActivity::class.java))
            }
        }
    }

    override fun getItemCount(): Int {
        return atcivityListModelList.size
    }

    class ViewHolder(var itemRowBinding: ItemRowBinding) : RecyclerView.ViewHolder(itemRowBinding.root) {
        var recyclerBindingDataAdapter: MainAdapter? = null
    }

    init {
        this.atcivityListModelList = atcivityListModelList
        this.context = context
    }
}