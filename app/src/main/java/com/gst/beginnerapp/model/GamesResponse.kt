package com.gst.beginnerapp.model

import com.squareup.moshi.Json


data class GamesResponse(
    @Json(name = "data")
    val data: List<Game>? = null,

    @Json(name = "meta")
    val meta: Meta? = null
)