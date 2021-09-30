package com.example.mvvmdemo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmdemo.R
import com.example.mvvmdemo.databinding.ActivityRoomDbactivityBinding
import com.example.mvvmdemo.dbmanager.RoomDBManager
import com.example.mvvmdemo.models.Quote
import com.example.mvvmdemo.repositories.QuoteRepository
import com.example.mvvmdemo.viewModelFactory.RoomDbViewModelFactory
import com.example.mvvmdemo.viewmodels.RoomDbViewModel

class RoomDBActivity : AppCompatActivity() {

    lateinit var binding: ActivityRoomDbactivityBinding
    lateinit var roomDbViewModel: RoomDbViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_room_dbactivity)

        val quoteDao = RoomDBManager.getDatabase(applicationContext).quoteDao()
        val quoteRepository = QuoteRepository(quoteDao)

        roomDbViewModel = ViewModelProvider(this,
            RoomDbViewModelFactory(quoteRepository)).get(RoomDbViewModel::class.java)

        roomDbViewModel.getQuotes().observe(this, {

            binding.quotes = it.toString()
        })

        binding.button.setOnClickListener {

            val quote = Quote(null, "This is Test text", "Pawan jha")
            roomDbViewModel.insertQuotes(quote)
        }
    }
}