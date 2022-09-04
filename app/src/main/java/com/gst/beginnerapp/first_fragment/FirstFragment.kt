package com.gst.beginnerapp.first_fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gst.beginnerapp.databinding.FragmentFirstBinding
import com.gst.beginnerapp.model.Game
import com.gst.beginnerapp.model.GamesResponse
import com.gst.beginnerapp.retrofit.RetrofitBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {
    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val mAdapter: FirstAdapter by lazy {
        FirstAdapter()
    }

    companion object{
        private const val TAG = "FIRST FRAGMENT => "
    }

    private val gameList = arrayListOf<Game>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            with(rv){
                adapter = mAdapter
            }
        }

        val repos = RetrofitBuilder.service.getGames()
        repos?.enqueue(object : Callback<GamesResponse>{
            override fun onResponse(call: Call<GamesResponse>, response: Response<GamesResponse>) {

                response.body()?.data?.let { listGame ->
                    Log.e(TAG, "${listGame}")

                    for (game in listGame) {
                        Log.e(TAG, "${game.date}")
                    }

                    gameList.addAll(listGame)
                    mAdapter.updateData(gameList)
                }
            }

            override fun onFailure(call: Call<GamesResponse>, t: Throwable) {
                Log.e(TAG, "${t.message}")
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}