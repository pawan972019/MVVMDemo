package com.example.mvvmdemo.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvmdemo.R;
import com.example.mvvmdemo.databinding.ItemRowBinding;
import com.example.mvvmdemo.models.NicePlaces;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerBindingDataAdapter extends RecyclerView.Adapter<RecyclerBindingDataAdapter.ViewHolder> {

    List<NicePlaces> nicePlacesList = new ArrayList<>();
    Context context;

    public RecyclerBindingDataAdapter(Context context, List<NicePlaces> nicePlacesList){

        this.nicePlacesList = nicePlacesList;
        this.context = context;
    }

    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {

        ItemRowBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_row, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NotNull ViewHolder holder, int position) {

        NicePlaces nicePlaces = nicePlacesList.get(position);
        holder.itemRowBinding.setNicePlace(nicePlaces);
    }

    @Override
    public int getItemCount() {
        return nicePlacesList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        public ItemRowBinding itemRowBinding;

        public RecyclerBindingDataAdapter recyclerBindingDataAdapter;

        public ViewHolder(ItemRowBinding itemRowBinding) {
            super(itemRowBinding.getRoot());
            this.itemRowBinding = itemRowBinding;
        }
    }
}
