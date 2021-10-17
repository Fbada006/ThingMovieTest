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

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.thingthing.thatthing.model.TvShow
import com.thingthing.thatthing.network.TmdbService
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ShowRepositoryImpl @Inject constructor(
    private val tmdbPagingDataSource: TmdbPagingDataSource,
    private val tmdbService: TmdbService
) : ShowRepository {

    private val pagingConfig = PagingConfig(
        pageSize = 20,
        enablePlaceholders = false,
    )

    override fun getTvShows(): Flow<PagingData<TvShow>> =
        Pager(config = pagingConfig) { tmdbPagingDataSource }.flow

    override fun getSimilarTvShows(tvId: Int): Flow<PagingData<TvShow>> =
        Pager(config = pagingConfig) { SimilarTmdbPagingDataSource(tmdbService, tvId) }.flow
}