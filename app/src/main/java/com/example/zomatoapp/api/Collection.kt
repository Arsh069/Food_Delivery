package com.example.zomatoapp.api


import com.google.gson.annotations.SerializedName

data class Collection(
    @SerializedName("collection")
    val collection: CollectionX
)