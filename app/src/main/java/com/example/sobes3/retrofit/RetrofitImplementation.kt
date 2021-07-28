package com.example.sobes3.retrofit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.HTTP

class RetrofitImplementation {

    fun initRetorfit(): ApiService {
        val builder = OkHttpClient.Builder()
        builder.build()

        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        return Retrofit.Builder()
            .baseUrl("https://picsum.photos/v2/")
            .client(
                OkHttpClient.Builder().addInterceptor(interceptor)
                    .build()
            )
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)

    }

}