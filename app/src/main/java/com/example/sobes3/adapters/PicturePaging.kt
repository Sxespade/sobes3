package com.example.sobes3.adapters

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.sobes3.retrofit.ApiService
import com.example.sobes3.retrofit.entity.Picture
import retrofit2.HttpException
import java.io.IOException

class PicturePaging(
    val backend: ApiService
) : PagingSource<Int, Picture>() {
    override suspend fun load(
        params: LoadParams<Int>
    ): LoadResult<Int, Picture> {
        try {
            // Start refresh at page 1 if undefined.
            val nextPageNumber = params.key ?: 1
            val response = backend.loadPicture(nextPageNumber.toString(),"100")
            return LoadResult.Page(
                data = response,
                prevKey = null, // Only paging forward.
                nextKey = nextPageNumber+1
            )
        } catch (e: IOException) {
            // IOException for network failures.
            return LoadResult.Error(e)
        } catch (e: HttpException) {
            // HttpException for any non-2xx HTTP status codes.
            return LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Picture>): Int? {
        // Try to find the page key of the closest page to anchorPosition, from
        // either the prevKey or the nextKey, but you need to handle nullability
        // here:
        //  * prevKey == null -> anchorPage is the first page.
        //  * nextKey == null -> anchorPage is the last page.
        //  * both prevKey and nextKey null -> anchorPage is the initial page, so
        //    just return null.
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}