package com.ricdev.uwatch.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.ricdev.uwatch.data.remote.MovieDBApi
import com.ricdev.uwatch.data.remote.dto.toMovieList
import com.ricdev.uwatch.domain.model.Movie
import java.io.IOException
import retrofit2.HttpException

class MoviePagingSource(
    private val movieDbApi: MovieDBApi,
) : PagingSource<Int, Movie>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        return try {
            val currentPage = params.key ?: 1
            val movieListDto = movieDbApi.getTrendingMovies(page = currentPage).toMovieList()
            val movies = movieListDto.results

            LoadResult.Page(
                data = movies,
                prevKey = if (currentPage == 1) null else currentPage - 1,
                nextKey = if (movies.isEmpty()) null else currentPage + 1
            )
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}
