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
package com.thingthing.thatthing.network

import com.thingthing.thatthing.model.ShowResponse
import com.thingthing.thatthing.utils.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TmdbService {
    @GET("tv/top_rated")
    suspend fun getTvShows(
        @Query("page") page: Int = 1,
        @Query("api_key") apiKey: String = API_KEY
    ): Response<ShowResponse>

    @GET("tv/{tv_id}/similar")
    suspend fun getSimilarTvShows(
        @Query("page") page: Int = 1,
        @Path("tv_id") tvId: Int = 1,
        @Query("api_key") apiKey: String = API_KEY
    ): Response<ShowResponse>
}