package com.example.zomatoapp.Repository

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.example.zomatoapp.FoodService
import com.example.zomatoapp.api.CollectionX
import com.example.zomatoapp.api.FoodApi
import com.example.zomatoapp.api.food
import retrofit2.Response

class Repository(var context: Context) {
    val showProgress = MutableLiveData<Boolean>()
    var food = MutableLiveData<food>()

    suspend fun getPost(lat:Double,lon:Double):Response<food>{
        showProgress.value=true
        return FoodService.foodInstance.getFood(lat,lon)
    }
}
