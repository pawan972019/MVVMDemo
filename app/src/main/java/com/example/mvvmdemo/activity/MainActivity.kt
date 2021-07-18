package com.example.mvvmdemo.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmdemo.R
import com.example.mvvmdemo.adapters.MainAdapter
import com.example.mvvmdemo.databinding.ActivityMainBinding
import com.example.mvvmdemo.models.NicePlaces
import com.example.mvvmdemo.viewmodels.MainActivityViewModel

class MainActivity : AppCompatActivity(), View.OnClickListener {
    var mainBinding: ActivityMainBinding? = null
    var mainActivityViewModel: MainActivityViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        mainActivityViewModel!!.init()

        val recyclerBindingDataAdapter = MainAdapter(this, mainActivityViewModel!!.nicePlaces!!.value as ArrayList)
        mainBinding?.let { it.setNicePlaceAdapter(recyclerBindingDataAdapter) }
        mainBinding?.let { it.setOnClickListener(this) }

        mainActivityViewModel!!.nicePlaces!!.observe(
            this,
            { recyclerBindingDataAdapter.notifyDataSetChanged() })

        mainActivityViewModel!!.isLoading.observe(this, { aBoolean ->
            if (aBoolean) {
                showProgressBar()
            } else {
                hideProgressBar()
            }
            mainBinding?.let { it.placeRecyclerView.smoothScrollToPosition(mainActivityViewModel!!.nicePlaces!!.value!!.size - 1) }
        })
    }

    private fun showProgressBar() {
        mainBinding!!.progressBar.visibility = View.VISIBLE
    }

    private fun hideProgressBar() {
        mainBinding!!.progressBar.visibility = View.GONE
    }

    override fun onClick(v: View) {
        if (v === mainBinding!!.fab) {
            mainActivityViewModel!!.addNewValue(
                NicePlaces(
                    "Jammu",
                    "http://d2c018txhbneoo.cloudfront.net/wakau/videoThumbnail/6188-1616173281-1625460864.jpg"
                )
            )
        }
    }
}