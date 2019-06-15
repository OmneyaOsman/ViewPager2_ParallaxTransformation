package com.omni.viewpager2.entities

import androidx.lifecycle.MutableLiveData
import com.omni.viewpager2.R


object DataGenerator {

    private val list = listOf(
        Recipe(
            "1",
            R.drawable.chicken,
            "Herb Roasted Chicken"
        ),
        Recipe(
            "2",
            R.drawable.pasta,
            "Pesto pasta"
        ),
        Recipe(
            "3",
            R.drawable.pie,
            "Pot Pie"
        ),
        Recipe(
            "4",
            R.drawable.ribs,
            "roasted ribs"
        )
    )
    val RECIPES: MutableLiveData<List<Recipe>> = list.toMutableLiveData()

}

fun <T> T.toMutableLiveData(): MutableLiveData<T> {
    return MutableLiveData<T>()
        .also { it.postValue(this) }
}