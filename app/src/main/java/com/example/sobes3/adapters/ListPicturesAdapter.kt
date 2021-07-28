package com.example.sobes3.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.mvp.view.image.GlideImageLoader
import com.example.sobes3.R
import com.example.sobes3.retrofit.entity.Picture

class ListPicturesAdapter(private val data: List<Picture>,diffCallback: DiffUtil.ItemCallback<Picture>)
    : PagingDataAdapter<Picture, ListPicturesAdapter.MyViewHolder>(diffCallback) {

    private val imageLoader = GlideImageLoader()

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image = view.findViewById<View>(R.id.iv_image) as ImageView
        val author = view.findViewById(R.id.iv_author) as TextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_user, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        imageLoader.loadImage(data[position].downloadUrl,holder.image)
        holder.author.text = data[position].author

    }


    override fun getItemCount(): Int {
        return data.size
    }

}