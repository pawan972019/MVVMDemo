package com.example.mvvmdemo.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmdemo.models.NicePlaces
import com.example.mvvmdemo.repositories.NicePlaceRepository
import com.example.mvvmdemo.repositories.NicePlaceRepository.Companion.instance

class MainActivityViewModel : ViewModel() {
    private var mNicePlaces: MutableLiveData<MutableList<NicePlaces>>? = null
    private var niceRepo: NicePlaceRepository? = null
    private val isUpdating = MutableLiveData<Boolean>()

    fun init() {
        if (mNicePlaces != null) {
            return
        }
        niceRepo = instance
        mNicePlaces = niceRepo!!.nicePlace
    }

    fun addNewValue(nicePlaces: NicePlaces) {
        isUpdating.value = true
        val currentNicePlace = mNicePlaces!!.value!!
        currentNicePlace.add(nicePlaces)
        mNicePlaces!!.value = currentNicePlace
        isUpdating.value = false
    }

    val nicePlaces: LiveData<MutableList<NicePlaces>>?
        get() = mNicePlaces

    val isLoading: LiveData<Boolean>
        get() {
            return isUpdating
        }
}