package com.example.mvvmdemo.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmdemo.R
import com.example.mvvmdemo.viewModelFactory.SplashViewModelFactory
import com.example.mvvmdemo.databinding.ActivitySplashBinding
import com.example.mvvmdemo.repositories.Repository
import com.example.mvvmdemo.viewmodels.SplashViewModel

class SplashActivity : AppCompatActivity() {

    companion object {
        const val TAG = "SplashActivity"
    }

    private lateinit var splashViewModel: SplashViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val splashBinding = DataBindingUtil.setContentView<ActivitySplashBinding>(this, R.layout.activity_splash).apply {
            lifecycleOwner = this@SplashActivity
        }

        val repository = Repository()
        val viewModelFactory = SplashViewModelFactory(repository)
        splashViewModel = ViewModelProvider(this, viewModelFactory).get(SplashViewModel::class.java)
        splashBinding.splashViewModel = splashViewModel

        /*API Call*/
        splashViewModel.getAppConfig()

        splashViewModel.appConfigResponse.observe(this, Observer { response ->

            if (response.isSuccessful && response.body() != null) {
                val appConfigResponse = response.body()
                Log.e(TAG, "onCreate: " + appConfigResponse!!.data.data.updateDetails.forceUpdateText)
                startActivity(Intent(this, MainActivity::class.java))
            }else{
                Log.e(TAG, "onCreate: ${response.errorBody().toString()}")
            }
        })
    }
}