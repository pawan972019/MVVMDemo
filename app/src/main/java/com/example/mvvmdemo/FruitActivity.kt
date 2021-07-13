package com.example.mvvmdemo

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmdemo.databinding.ActivityFruitBinding
import com.example.mvvmdemo.viewmodels.FruitViewModel

class FruitActivity : AppCompatActivity() {

    lateinit var fruitBinding: ActivityFruitBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fruit)

        val fruitViewModel = ViewModelProvider(this).get(FruitViewModel::class.java)
        fruitBinding = DataBindingUtil.setContentView(this, R.layout.activity_fruit)
        fruitBinding.setLifecycleOwner(this@FruitActivity)
        fruitBinding.viewModel = fruitViewModel


        fruitViewModel.editTextContent.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })
    }
}