package com.example.zomatoapp.Repository

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.example.zomatoapp.FoodService
import com.example.zomatoapp.api.CollectionX
import com.example.zomatoapp.api.FoodApi
import retrofit2.Response

class Repository(var context: Context) {
    val showProgress = MutableLiveData<Boolean>()
    var food = MutableLiveData<FoodApi>()

    suspend fun getPost(lat:Double,lon:Double,userKey:String):Response<FoodApi>{
        showProgress.value=true
        return FoodService.foodInstance.getFood(lat,lon,userKey)
    }
}
