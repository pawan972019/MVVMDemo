package com.example.mvvmdemo

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmdemo.adapters.RecyclerViewAapter
import com.example.mvvmdemo.databinding.ActivityMainViewBinding
import com.example.mvvmdemo.models.NicePlaces
import com.example.mvvmdemo.viewmodels.MainActivityViewModel

class MainViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainViewBinding

    lateinit var recyclerViewAdapter: RecyclerViewAapter
    lateinit var mainActivityViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainViewBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        mainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        mainActivityViewModel.init()

        initializeRecylerView()

        mainActivityViewModel.nicePlaces!!.observe(this, { recyclerViewAdapter.notifyDataSetChanged() })

        mainActivityViewModel.isLoading.observe(this, {
            if (it) {
                showProgressBar()
            } else {
                hideProgressBar()
            }
            binding.placeRecyclerView.smoothScrollToPosition(mainActivityViewModel.nicePlaces!!.value!!.size - 1)
        })

        binding.fab.setOnClickListener(View.OnClickListener {
            mainActivityViewModel.addNewValue(NicePlaces("Shimla", "http://d2c018txhbneoo.cloudfront.net/wakau/videoThumbnail/6188-1616173281-1625460864.jpg"))
        })

    }

    private fun initializeRecylerView() {

        recyclerViewAdapter = RecyclerViewAapter(this, mainActivityViewModel.nicePlaces!!.value)
        val linearLayoutManager = LinearLayoutManager(this)
        binding.placeRecyclerView.layoutManager = linearLayoutManager
        binding.placeRecyclerView.adapter = recyclerViewAdapter
    }

    fun showProgressBar() {
        binding.progressBar.visibility = View.VISIBLE
    }

    fun hideProgressBar() {
        binding.progressBar.visibility = View.GONE
    }
}