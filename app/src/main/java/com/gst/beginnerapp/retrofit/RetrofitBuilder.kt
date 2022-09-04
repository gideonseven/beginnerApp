package com.gst.beginnerapp.retrofit

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


/**
 * Created by gideon on 9/4/2022
 * gideon@cicil.co.id
 * https://www.cicil.co.id/
 */
object RetrofitBuilder {
    private const val BASE_URL = "https://www.balldontlie.io/api/v1/"
    private val moshi = Moshi.Builder()
        // ... add your own JsonAdapters and factories ...
        // for parsing object inside arrayobject if not use, its gonna make object null
        .add(KotlinJsonAdapterFactory())
        .build()
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    var service: ApiService = retrofit.create(ApiService::class.java)
}