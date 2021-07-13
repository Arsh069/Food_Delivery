package com.example.zomatoapp

import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


const val BASE_URL="https://developers.zomato.com"
object FoodService{
    val foodInstance:ApiRequest
    init {
        val httpClient = OkHttpClient.Builder()

        httpClient.addInterceptor { chain ->
            val request: Request =
                chain.request().newBuilder().addHeader("user-key", "f5cd87e4deca15ff2a49d74ce3328e1b").build()
            chain.proceed(request)
        }

        val retrofit=Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(httpClient.build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        foodInstance=retrofit.create(ApiRequest::class.java)
    }
}