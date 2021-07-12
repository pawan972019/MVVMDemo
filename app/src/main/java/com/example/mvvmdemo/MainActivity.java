package com.example.mvvmdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import com.example.mvvmdemo.adapters.RecyclerBindingDataAdapter;
import com.example.mvvmdemo.databinding.ActivityMainBinding;
import com.example.mvvmdemo.models.NicePlaces;
import com.example.mvvmdemo.viewmodels.MainActivityViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityMainBinding mainBinding;
    MainActivityViewModel mainActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainActivityViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        mainActivityViewModel.init();

        RecyclerBindingDataAdapter recyclerBindingDataAdapter = new RecyclerBindingDataAdapter(this, mainActivityViewModel.getNicePlaces().getValue());
        mainBinding.setNicePlaceAdapter(recyclerBindingDataAdapter);
        mainBinding.setOnClickListener(this);

        mainActivityViewModel.getNicePlaces().observe(this, new Observer<List<NicePlaces>>() {
            @Override
            public void onChanged(List<NicePlaces> nicePlacesList) {
                recyclerBindingDataAdapter.notifyDataSetChanged();
            }
        });

        mainActivityViewModel.isLoading().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(aBoolean){
                    showProgressBar();
                }else{
                    hideProgressBar();
                }
                mainBinding.placeRecyclerView.smoothScrollToPosition(mainActivityViewModel.getNicePlaces().getValue().size() - 1);
            }
        });
    }

    private void showProgressBar(){
        mainBinding.progressBar.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar(){
        mainBinding.progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onClick(View v) {

        if(v == mainBinding.fab){
            mainActivityViewModel.addNewValue(new NicePlaces("Jammu", "http://d2c018txhbneoo.cloudfront.net/wakau/videoThumbnail/6188-1616173281-1625460864.jpg"));
        }
    }
}