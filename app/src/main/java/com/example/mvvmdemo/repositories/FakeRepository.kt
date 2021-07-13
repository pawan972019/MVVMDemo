package com.example.mvvmdemo.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import java.util.*

object FakeRepository {

    private val fruitName: List<String> =
        listOf(
            "Apple",
            "Banana",
            "Orange",
            "Kiwi",
            "Grapes",
            "Fig",
            "Pear",
            "Strawberry",
            "Gooseberry",
            "Raspberry"
        )

    private val _currentRandomFruitName = MutableLiveData<String>()

    val currentRandomFruitName: LiveData<String>
        get() = _currentRandomFruitName

    init {
        _currentRandomFruitName.value = fruitName.first()
    }

    fun getRandomFruitName():String{
        val random = Random()
        return fruitName[random.nextInt(fruitName.size)]
    }

    fun changeCurrentRandomFruitName(){
        _currentRandomFruitName.value = getRandomFruitName()
    }
}