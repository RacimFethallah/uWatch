//package com.ricdev.uwatch.data.paging
//
//import androidx.paging.PagingSource
//import androidx.paging.PagingState
//import com.ricdev.uwatch.data.remote.MovieDBApi
//import com.ricdev.uwatch.domain.model.Movie
//import retrofit2.HttpException
//import java.io.IOException
//
//class TrendingPagingSource(private val movieDbApi: MovieDBApi) : PagingSource<Int, Movie>(){
//    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
//        val position = params.key ?: 1
//        return try {
////            val data = movieDbApi.getTrendingMovies(
////                page = position,
////            )
//            val nextKey = if (data.results?.isEmpty() == true) {
//                null
//            } else {
//                // initial load size = 3 * NETWORK_PAGE_SIZE
//                // ensure we're not requesting duplicating items, at the 2nd request
//                position + (params.loadSize / NETWORK_PAGE_SIZE)
//            }
//            val prevKey = if (position == 1) null else position - 1
//            LoadResult.Page(
//                data = data.results!!,
//                prevKey = prevKey,
//                nextKey = nextKey
//            )
//        } catch (e: IOException) {
//            return LoadResult.Error(e)
//        } catch (e: HttpException) {
//            return LoadResult.Error(e)
//        }
//    }
//
//    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
//        return state.anchorPosition
//    }
//}