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
package com.thingthing.thatthing.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.thingthing.thatthing.databinding.TvShowRowBinding
import com.thingthing.thatthing.model.TvShow
import com.thingthing.thatthing.utils.TvShowDiffUtilCallBack

class TvShowAdapter : PagingDataAdapter<TvShow, TvShowAdapter.TvShowViewHolder>(TvShowDiffUtilCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val binding = TvShowRowBinding.inflate(LayoutInflater.from(parent.context))
        return TvShowViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    class TvShowViewHolder(private val binding: TvShowRowBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(tvShow: TvShow) {
            binding.showName.text = tvShow.name
            binding.showRating.text = tvShow.vote_average.toString()
            binding.showPoster.load("https://image.tmdb.org/t/p/w500${tvShow.poster_path}")
        }
    }
}