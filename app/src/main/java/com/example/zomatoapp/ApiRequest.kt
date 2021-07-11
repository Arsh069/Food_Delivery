package com.example.zomatoapp

import com.example.zomatoapp.api.CollectionX
import com.example.zomatoapp.api.FoodApi
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query
import java.nio.channels.spi.AbstractSelectionKey

interface ApiRequest {
    @GET("/api/v2.1/collections")
    suspend fun getFood(@Header("UserKey")userKey: String,
                        @Query("lat") lat:Int,
                        @Query("lon") lon:Int) :Response<FoodApi>
}