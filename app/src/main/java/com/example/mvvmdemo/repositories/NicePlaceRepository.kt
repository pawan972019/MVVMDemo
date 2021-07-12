package com.example.mvvmdemo.repositories

import androidx.lifecycle.MutableLiveData
import com.example.mvvmdemo.models.NicePlaces
import java.util.*

/*
* Single pattern
* */
class NicePlaceRepository {

    private lateinit var dataSet: MutableList<NicePlaces>

    //we get data from web services
    val nicePlace: MutableLiveData<MutableList<NicePlaces>>
        get() {
            setDataSet()
            val data = MutableLiveData<MutableList<NicePlaces>>()
            data.value = dataSet
            return data
        }

    private fun setDataSet() {
        dataSet = mutableListOf()


        dataSet.add(
            NicePlaces(
                "Pune",
                "http://d2c018txhbneoo.cloudfront.net/wakau/videoThumbnail/6188-1616173281-1625460864.jpg"
            )
        )
        dataSet.add(
            NicePlaces(
                "Mumbai",
                "http://d2c018txhbneoo.cloudfront.net/wakau/videoThumbnail/6188-1616173281-1625460864.jpg"
            )
        )
        dataSet.add(
            NicePlaces(
                "Gurgaon",
                "http://d2c018txhbneoo.cloudfront.net/wakau/videoThumbnail/6188-1616173281-1625460864.jpg"
            )
        )
        dataSet.add(
            NicePlaces(
                "Delhi",
                "http://d2c018txhbneoo.cloudfront.net/wakau/videoThumbnail/6188-1616173281-1625460864.jpg"
            )
        )
        dataSet.add(
            NicePlaces(
                "Agra",
                "http://d2c018txhbneoo.cloudfront.net/wakau/videoThumbnail/6188-1616173281-1625460864.jpg"
            )
        )
        dataSet.add(
            NicePlaces(
                "Manali",
                "http://d2c018txhbneoo.cloudfront.net/wakau/videoThumbnail/6188-1616173281-1625460864.jpg"
            )
        )
    }

    companion object {
        @JvmStatic
        var instance: NicePlaceRepository? = null
            get() {
                if (field == null) {
                    field = NicePlaceRepository()
                }
                return field
            }
            private set
    }
}