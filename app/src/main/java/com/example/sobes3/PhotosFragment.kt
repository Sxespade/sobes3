package com.example.sobes3

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.sobes3.adapters.ListPicturesAdapter
import com.example.sobes3.databinding.FragmentPhotosBinding
import com.example.sobes3.retrofit.RetrofitImplementation
import com.example.sobes3.retrofit.entity.Picture
import org.koin.android.ext.android.bind
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class PhotosFragment: Fragment(R.layout.fragment_photos) {

    lateinit var binding: FragmentPhotosBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPhotosBinding.bind(view)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val retrofitImplementation = RetrofitImplementation()
        val apiService = retrofitImplementation.initRetorfit()
            PicturePaging("1",apiService)
    }

}