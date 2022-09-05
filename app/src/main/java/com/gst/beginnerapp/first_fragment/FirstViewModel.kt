package com.gst.beginnerapp.first_fragment

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gst.beginnerapp.model.Game
import com.gst.beginnerapp.model.GamesResponse
import com.gst.beginnerapp.retrofit.ApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


/**
 * Created by gideon on 9/5/2022
 * gideon@cicil.co.id
 * https://www.cicil.co.id/
 */

@HiltViewModel
class FirstViewModel @Inject constructor(
    private val apiService: ApiService
) : ViewModel() {

    companion object {
        private val TAG = FirstViewModel::class.java.simpleName.toString()
    }

    val gameList: MutableLiveData<ArrayList<Game>> =
        MutableLiveData<ArrayList<Game>>().apply { value = null }

    init {
        getGames()
    }

    private fun getGames() {
        apiService.getGames()?.enqueue(object : Callback<GamesResponse> {
            override fun onResponse(call: Call<GamesResponse>, response: Response<GamesResponse>) {
                response.body()?.data?.let { listGame ->
                    Log.e(TAG, "$listGame")

                    for (game in listGame) {
                        Log.e(TAG, "${game.date}")
                    }

                    val arrayListGame = arrayListOf<Game>()
                    arrayListGame.addAll(listGame)
                    gameList.postValue(arrayListGame)
                }
            }

            override fun onFailure(call: Call<GamesResponse>, t: Throwable) {
                Log.e(TAG, "${t.message}")
            }
        })
    }
}