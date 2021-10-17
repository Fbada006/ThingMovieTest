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
package com.thingthing.thatthing.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.thingthing.thatthing.model.TvShow
import com.thingthing.thatthing.repository.ShowRepository
import com.thingthing.thatthing.utils.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TmdbViewModel @Inject constructor(private val repository: ShowRepository) : ViewModel() {

    private val _event: MutableSharedFlow<Event<TvShow?>> = MutableSharedFlow()
    val event = _event.asSharedFlow()

    fun getAllShows() = repository.getTvShows().cachedIn(viewModelScope)

    fun getSimilartvShows(tvShow: TvShow) =
        repository.getSimilarTvShows(tvShow)

    fun displayShowDetails(show: TvShow?) {
        viewModelScope.launch {
            _event.emit(Event(show))
        }
    }
}