package com.example.myapplication.di

import com.example.sobes3.PhotosFragment
import com.example.sobes3.retrofit.RetrofitImplementation
import org.koin.dsl.module

/**
 * @author Alex Volkov(Volkoks)
 *
 * Created 08.04.2021
 */
val appModule = module {
    single { RetrofitImplementation().initRetorfit() }
}




