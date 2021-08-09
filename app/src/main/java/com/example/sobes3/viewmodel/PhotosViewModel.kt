package com.example.sobes3.viewmodel

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.myapplication.data.state.AppState
import com.example.sobes3.adapters.PicturePaging
import com.example.sobes3.retrofit.ApiService
import com.example.sobes3.retrofit.entity.Example
import com.example.sobes3.retrofit.entity.Picture
import kotlinx.coroutines.flow.Flow

class PhotosViewModel(private val apiService: ApiService): BaseViewModel<AppState>() {
    fun subscribe(): LiveData<AppState> = liveDataViewmodel

    val pictures: Flow<PagingData<Picture>> = Pager(PagingConfig(pageSize = 1)) {
        PicturePaging(apiService)
    }.flow.cachedIn(viewModelCoroutineScope)



    override fun errorReturned(t: Throwable) {
    }
}