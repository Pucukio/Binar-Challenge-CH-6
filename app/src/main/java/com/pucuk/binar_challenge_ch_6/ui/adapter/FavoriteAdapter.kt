package com.pucuk.binar_challenge_ch_6.ui.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pucuk.binar_challenge_ch_6.R
import com.pucuk.binar_challenge_ch_6.data.database.DataFav
import com.pucuk.binar_challenge_ch_6.databinding.ItemFavBinding


class FavoriteAdapter(private val listDataFav: List<DataFav>) : RecyclerView.Adapter<FavoriteAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ItemFavBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(dataFav: DataFav) {
            binding.tvTitle.text = dataFav.title
            binding.tvDate.text = dataFav.date
            Glide.with(itemView).load(dataFav.image).into(binding.ivImg)
            binding.root.setOnClickListener {
                it.findNavController()
                    .navigate(
                        R.id.action_favoriteFragment_to_detailFragment,
                        Bundle().apply { putInt("MOVIE_ID", dataFav.id) })
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(ItemFavBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun getItemCount(): Int = listDataFav.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(listDataFav[position])

}
