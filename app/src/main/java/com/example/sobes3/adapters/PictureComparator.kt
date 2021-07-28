package com.example.sobes3.adapters

import androidx.recyclerview.widget.DiffUtil
import com.example.sobes3.retrofit.entity.Picture

object PictureComparator : DiffUtil.ItemCallback<Picture>() {
    override fun areItemsTheSame(oldItem: Picture, newItem: Picture): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Picture, newItem: Picture): Boolean {
        return oldItem.id == newItem.id && oldItem.downloadUrl == newItem.downloadUrl
    }
}