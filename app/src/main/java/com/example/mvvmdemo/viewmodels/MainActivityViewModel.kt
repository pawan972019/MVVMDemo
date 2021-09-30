package com.example.mvvmdemo.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmdemo.models.AtcivityListModel
import com.example.mvvmdemo.repositories.MainActivityRepository
import com.example.mvvmdemo.repositories.MainActivityRepository.Companion.instance

class MainActivityViewModel : ViewModel() {
    private var mAtcivityListModel: MutableLiveData<MutableList<AtcivityListModel>>? = null
    private var niceRepo: MainActivityRepository? = null
    private val isUpdating = MutableLiveData<Boolean>()

    fun init() {
        if (mAtcivityListModel != null) {
            return
        }
        niceRepo = instance
        mAtcivityListModel = niceRepo!!.activity
    }

    fun addNewValue(atcivityListModel: AtcivityListModel) {
        isUpdating.value = true
        val currentNicePlace = mAtcivityListModel!!.value!!
        currentNicePlace.add(atcivityListModel)
        mAtcivityListModel!!.value = currentNicePlace
        isUpdating.value = false
    }

    val atcivityListModel: LiveData<MutableList<AtcivityListModel>>?
        get() = mAtcivityListModel

    val isLoading: LiveData<Boolean>
        get() {
            return isUpdating
        }
}