package com.gst.beginnerapp.first_fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gst.beginnerapp.R
import com.gst.beginnerapp.databinding.ItemRecyclerviewBinding
import com.gst.beginnerapp.model.Game


/**
 * Created by gideon on 9/4/2022
 * gideon@cicil.co.id
 * https://www.cicil.co.id/
 */
class FirstAdapter : RecyclerView.Adapter<FirstAdapter.ItemViewHolder>() {

    private val listItem = arrayListOf<Game>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            ItemRecyclerviewBinding.bind(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_recyclerview, parent, false)
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(listItem[position])
    }

    override fun getItemCount() = listItem.size

    fun updateData(list: ArrayList<Game>) {
        listItem.clear()
        listItem.addAll(list)
        notifyItemRangeChanged(0, list.size)
    }

    inner class ItemViewHolder(private val binding: ItemRecyclerviewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Game) {
            val homeTeam = item.homeTeam
            val visitorTeam = item.visitorTeam
            val combinedString = "${visitorTeam?.name} vs ${homeTeam?.name} "
            binding.tv.text = combinedString
        }
    }
}