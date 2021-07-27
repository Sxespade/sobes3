package com.example.myapplication.mvp.view.image

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

class GlideImageLoader : IImageLoader<ImageView?> {

    override fun loadImage(url: String?, container: ImageView?) {
        Glide.with(container!!.context).load(url).diskCacheStrategy(DiskCacheStrategy.ALL).into(container)
    }
}
