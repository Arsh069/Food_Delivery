package com.example.zomatoapp.api


import com.example.zomatoapp.api.Collection
import com.google.gson.annotations.SerializedName

data class FoodApi(
    @SerializedName("collections")
    val collections: List<CollectionX>?,
    @SerializedName("display_text")
    val displayText: String,
    @SerializedName("has_more")
    val hasMore: Int,
    @SerializedName("has_total")
    val hasTotal: Int,
    @SerializedName("share_url")
    val shareUrl: String,
    @SerializedName("user_has_addresses")
    val userHasAddresses: Boolean
)