package com.example.mvvmdemo.activity

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmdemo.BuildConfig
import com.example.mvvmdemo.R
import com.example.mvvmdemo.apiManager.RetrofitApiClient
import com.example.mvvmdemo.databinding.ActivityFruitBinding
import com.example.mvvmdemo.models.apiModel.request.AppConfigRequest
import com.example.mvvmdemo.models.apiModel.request.Locale
import com.example.mvvmdemo.models.apiModel.response.AppConfigResponse
import com.example.mvvmdemo.viewmodels.FruitViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FruitActivity : AppCompatActivity() {

    lateinit var fruitBinding: ActivityFruitBinding

    companion object {
        const val CONTENT_TYPE = "application/json"
        const val TAG = "FruitActivity"
    }

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

