package com.utab.onlineshopkotlin.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Category(
    @Json(name = "id") var id: String = "",
    @Json(name = "name") var name: String = "",
    @Json(name = "image") var image: Image = Image("")
)

@JsonClass(generateAdapter = true)
data class Image(@Json(name = "src") var imageUrl: String = "")