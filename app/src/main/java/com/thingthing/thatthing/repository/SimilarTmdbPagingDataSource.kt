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
import retrofit2.HttpException
import timber.log.Timber
import java.io.IOException

class SimilarTmdbPagingDataSource(
    private val tmdbService: TmdbService,
    private val tvId: Int
) :
    PagingSource<Int, TvShow>() {

    private var currentPage: Int = 1

    override fun getRefreshKey(state: PagingState<Int, TvShow>): Int? = state.anchorPosition

    override val keyReuseSupported: Boolean = true

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, TvShow> {
        return try {
            val showResponse = tmdbService.getSimilarTvShows(
                page = currentPage,
                tvId = tvId
            ).body()
            Timber.e("Similar shows response is $showResponse")
            LoadResult.Page(
                showResponse?.tvShows ?: listOf(),
                null,
                currentPage++
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
}