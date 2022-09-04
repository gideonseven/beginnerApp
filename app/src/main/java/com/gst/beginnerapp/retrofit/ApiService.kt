package com.gst.beginnerapp.retrofit

import com.gst.beginnerapp.model.GamesResponse
import retrofit2.Call
import retrofit2.http.GET


/**
 * Created by gideon on 9/4/2022
 * gideon@cicil.co.id
 * https://www.cicil.co.id/
 */

interface ApiService {
    @GET("games")
    fun getGames(): Call<GamesResponse>?
}