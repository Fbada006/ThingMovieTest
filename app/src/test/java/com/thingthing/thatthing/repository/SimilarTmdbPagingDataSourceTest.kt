package com.thingthing.thatthing.repository

import androidx.paging.PagingSource
import com.google.common.truth.Truth
import com.thingthing.thatthing.utils.FakeTmdbService
import com.thingthing.thatthing.utils.similarShows
import kotlinx.coroutines.runBlocking
import org.junit.Test

class SimilarTmdbPagingDataSourceTest {

    @Test
    fun `loading similar shows from data source returns correct data`() = runBlocking {
        val source = SimilarTmdbPagingDataSource(FakeTmdbService(), similarShows[0])
        Truth.assertThat(
            source.load(
                PagingSource.LoadParams.Refresh(
                    key = null,
                    loadSize = 2,
                    placeholdersEnabled = false
                )
            )
        ).isEqualTo(
            PagingSource.LoadResult.Page(
                data = similarShows,
                prevKey = null,
                nextKey = 1
            )
        )
    }
}