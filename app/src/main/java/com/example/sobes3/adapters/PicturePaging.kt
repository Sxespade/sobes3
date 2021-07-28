package com.example.sobes3.adapters

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.sobes3.retrofit.ApiService
import com.example.sobes3.retrofit.entity.Picture
import java.lang.Exception

class PicturePaging(val s:String, val apiService: ApiService): PagingSource<Int, Picture>() {
    override fun getRefreshKey(state: PagingState<Int, Picture>): Int? {
       return state.anchorPosition?.let {
            val anchorPage = state.closestPageToPosition(it)
            anchorPage?.prevKey?.plus(1)?:anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Picture> {
        val page = params.key?:1

        return try {
            val data = apiService.loadPicture(s,page.toString())
            LoadResult.Page(
                data = data,
                prevKey = if(page==1) null else page-1,
                nextKey = if(data.isEmpty())null else page+1
            )

        } catch (e: Exception){
            LoadResult.Error(e)
        }
    }
}