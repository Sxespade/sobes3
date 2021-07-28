package com.example.sobes3.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitImplementation {

    fun initRetorfit(): ApiService {
        val builder = OkHttpClient.Builder()
        builder.build()

        return Retrofit.Builder()
            .baseUrl("https://picsum.photos/v2/")
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)

    }

}