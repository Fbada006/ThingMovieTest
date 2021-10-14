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
package com.thingthing.thatthing.di

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.thingthing.thatthing.network.TmdbService
import com.thingthing.thatthing.utils.HttpClient
import com.thingthing.thatthing.utils.LoggingInterceptor
import com.thingthing.thatthing.utils.TMDB_BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun providesTmdbService(retrofit: Retrofit): TmdbService =
        retrofit.create(TmdbService::class.java)

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(TMDB_BASE_URL)
        .client(HttpClient.create(LoggingInterceptor.create()))
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()
}