package com.example.sobes3.adapters

import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.mvp.view.image.GlideImageLoader
import com.example.sobes3.databinding.ItemUserBinding
import com.example.sobes3.retrofit.entity.Picture

class MainViewHolder(
    private val binding: ItemUserBinding
) : RecyclerView.ViewHolder(binding.root) {

    val glideImageLoader = GlideImageLoader()

    fun bind(picture: Picture?) {
        with(binding) {
                glideImageLoader.loadImage(picture?.posterPath,ivImage)
                ivAuthor.text = picture?.name
        }
    }
}