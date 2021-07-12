package com.example.zomatoapp.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.zomatoapp.Repository.Repository
import com.example.zomatoapp.api.CollectionX
import retrofit2.Response
import androidx.lifecycle.*
import com.example.zomatoapp.api.FoodApi
import kotlinx.coroutines.launch

class MainViewModel(private val repository: Repository):ViewModel() {

    var showProgress: LiveData<Boolean>
    var food:MutableLiveData<Response<FoodApi>>

    init {
        this.showProgress=repository.showProgress
        this.food= MutableLiveData()
    }

    fun getFood(lat:Double,lon:Double,userKey:String){
        viewModelScope.launch {
            val food1=repository.getPost(lat,lon, userKey)
            food.value=food1
            Log.d("HELLO",food1.body().toString())
        }
    }
}
