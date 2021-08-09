package com.example.sobes3.retrofit

import com.example.sobes3.retrofit.entity.Example
import com.example.sobes3.retrofit.entity.Picture
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("3/search/collection")
    suspend fun loadPicture(
        @Query("api_key") page: String,
        @Query("query") limit: String
    ): Example

}