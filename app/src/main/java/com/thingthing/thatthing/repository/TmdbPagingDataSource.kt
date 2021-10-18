/*
 * Copyright 2020 ThingThing
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.thingthing.thatthing.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.thingthing.thatthing.model.TvShow
import com.thingthing.thatthing.network.TmdbService
import com.thingthing.thatthing.utils.NETWORK_PAGE_SIZE
import com.thingthing.thatthing.utils.TMDB_STARTING_PAGE_INDEX
import retrofit2.HttpException
import timber.log.Timber
import java.io.IOException
import javax.inject.Inject

class TmdbPagingDataSource @Inject constructor(private val tmdbService: TmdbService) :
    PagingSource<Int, TvShow>() {

    private var currentPage: Int = 1

    override val keyReuseSupported: Boolean = true

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, TvShow> {
        return try {
            val position = params.key ?: currentPage
            val showResponse = tmdbService.getTvShows(page = position).body()
            val nextKey = if (showResponse?.tvShows.isNullOrEmpty()) {
                null
            } else {
                // initial load size = 3 * NETWORK_PAGE_SIZE
                // ensure we're not requesting duplicating items, at the 2nd request
                position + (params.loadSize / NETWORK_PAGE_SIZE)
            }
            LoadResult.Page(
                showResponse?.tvShows ?: listOf(),
                prevKey = if (position == TMDB_STARTING_PAGE_INDEX) null else position - 1,
                nextKey = nextKey
            )
        } catch (exception: IOException) {
            Timber.e("IO Exception similar $exception")
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            Timber.e("HttpException Exception similar $exception")
            return LoadResult.Error(exception)
        } catch (exception: Exception) {
            Timber.e("General Exception similar $exception")
            return LoadResult.Error(exception)
        }
    }

    // The refresh key is used for the initial load of the next PagingSource, after invalidation
    override fun getRefreshKey(state: PagingState<Int, TvShow>): Int? {
        // We need to get the previous key (or next key if previous is null) of the page
        // that was closest to the most recently accessed index.
        // Anchor position is the most recently accessed index
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}