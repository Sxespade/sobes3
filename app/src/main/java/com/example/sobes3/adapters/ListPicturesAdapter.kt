package com.example.sobes3.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.example.sobes3.databinding.ItemUserBinding
import com.example.sobes3.retrofit.entity.Example
import com.example.sobes3.retrofit.entity.Picture

class ListPicturesAdapter(diffCallback: DiffUtil.ItemCallback<Picture>) :
    PagingDataAdapter<Picture, MainViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MainViewHolder(
        ItemUserBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
}