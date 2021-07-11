package com.example.zomatoapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL="https://developers.zomato.com"
object FoodService{
    val foodInstance:ApiRequest
    init {
        val retrofit=Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        foodInstance=retrofit.create(ApiRequest::class.java)
    }
}