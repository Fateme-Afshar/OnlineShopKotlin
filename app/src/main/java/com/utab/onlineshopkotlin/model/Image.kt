package com.utab.onlineshopkotlin.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Image(@Json(name = "src") var imageUrl: String = "")