package com.example.sobes3

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
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
        retrofitImplementation.initRetorfit().loadPicture("1","100").enqueue(
            object: Callback<List<Picture>>{
                override fun onResponse(call: Call<List<Picture>>, response: Response<List<Picture>>) {
                    Log.d("TAG1", "onResponse: " + response.body())
                    val list = response.body() as List<Picture>
                    binding.recycle.adapter = ListPicturesAdapter(list)
                }

                override fun onFailure(call: Call<List<Picture>>, t: Throwable) {
                    Log.d("TAG1", "onFailure: " + t)
                }
            }
        )
    }

}