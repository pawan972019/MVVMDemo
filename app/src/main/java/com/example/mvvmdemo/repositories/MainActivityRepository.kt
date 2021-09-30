package com.example.mvvmdemo.repositories

import androidx.lifecycle.MutableLiveData
import com.example.mvvmdemo.models.AtcivityListModel

/*
* Single pattern
* */
class MainActivityRepository {

    private lateinit var dataSet: MutableList<AtcivityListModel>

    //we get data from web services
    val activity: MutableLiveData<MutableList<AtcivityListModel>>
        get() {
            setDataSet()
            val data = MutableLiveData<MutableList<AtcivityListModel>>()
            data.value = dataSet
            return data
        }

    private fun setDataSet() {
        dataSet = mutableListOf()

        dataSet.add(
            AtcivityListModel(
                "Fruit",
                "http://d2c018txhbneoo.cloudfront.net/wakau/videoThumbnail/6188-1616173281-1625460864.jpg"
            )
        )
        dataSet.add(
            AtcivityListModel(
                "Room Database",
                "http://d2c018txhbneoo.cloudfront.net/wakau/videoThumbnail/6188-1616173281-1625460864.jpg"
            )
        )
    }

    companion object {
        @JvmStatic
        var instance: MainActivityRepository? = null
            get() {
                if (field == null) {
                    field = MainActivityRepository()
                }
                return field
            }
            private set
    }
}