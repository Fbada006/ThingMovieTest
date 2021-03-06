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
package com.thingthing.thatthing.utils

import com.thingthing.thatthing.BuildConfig

const val TMDB_BASE_URL = "https://api.themoviedb.org/3/"
const val API_CONNECT_TIMEOUT = 300L
const val API_READ_TIMEOUT = 300L
const val IMAGE_BASE = "https://image.tmdb.org/t/p/w500"
const val NETWORK_PAGE_SIZE = 50
const val TMDB_STARTING_PAGE_INDEX = 1
const val NETWORK_STARTING_PAGE = 1
const val API_KEY = BuildConfig.API_KEY