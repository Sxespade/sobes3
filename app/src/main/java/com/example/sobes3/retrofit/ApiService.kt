package com.example.sobes3.retrofit

import com.example.sobes3.retrofit.entity.Picture
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("list")
    fun loadPicture(
        @Query("page") page: String,
        @Query("limit") limit: String
    ): Call<List<Picture>>

}