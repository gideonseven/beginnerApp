package com.gst.beginnerapp.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


/**
 * Created by gideon on 9/5/2022
 * gideon@cicil.co.id
 * https://www.cicil.co.id/
 */

@JsonClass(generateAdapter = true)
data class Team(

    @Json(name="division")
    val division: String? = null,

    @Json(name="conference")
    val conference: String? = null,

    @Json(name="full_name")
    val fullName: String? = null,

    @Json(name="city")
    val city: String? = null,

    @Json(name="name")
    val name: String? = null,

    @Json(name="id")
    val id: Int? = null,

    @Json(name="abbreviation")
    val abbreviation: String? = null
)