package com.thingthing.thatthing.utils

import com.thingthing.thatthing.model.ShowResponse
import com.thingthing.thatthing.network.TmdbService

class FakeTmdbService : TmdbService {

    override suspend fun getTvShows(page: Int, apiKey: String): ShowResponse {
        return ShowResponse(
            page = 1, tvShows = topShows
        )
    }

    override suspend fun getSimilarTvShows(tvId: Int, page: Int, apiKey: String): ShowResponse {
        return ShowResponse(
            page = 1, tvShows = similarShows
        )
    }
}