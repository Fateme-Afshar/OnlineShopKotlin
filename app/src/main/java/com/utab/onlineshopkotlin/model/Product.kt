package com.utab.onlineshopkotlin.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Product(
    @Json(name = "id") var id: Int = 0,
    @Json(name = "name") var name: String = "",
    @Json(name = "description") var description: String = "",
    @Json(name = "average_rating") var averageRating: String = "",
    @Json(name = "price") var price: String = "",
    @Json(name = "regular_price") var regularPrice: String = "",
    @Json(name="images") var image:List<Image>
)