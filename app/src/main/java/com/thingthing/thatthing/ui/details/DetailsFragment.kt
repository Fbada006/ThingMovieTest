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
package com.thingthing.thatthing.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DividerItemDecoration
import coil.load
import com.thingthing.thatthing.R
import com.thingthing.thatthing.databinding.FragmentDetailsBinding
import com.thingthing.thatthing.model.TvShow
import com.thingthing.thatthing.ui.TmdbViewModel
import com.thingthing.thatthing.ui.home.ShowLoadingAdapter
import com.thingthing.thatthing.utils.IMAGE_BASE
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class DetailsFragment : Fragment() {

    private val args by navArgs<DetailsFragmentArgs>()
    private val viewmodel by viewModels<TmdbViewModel>()
    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!
    private lateinit var tvShow: TvShow
    private val similarTvShowAdapter = SimilarTvShowAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvShow = args.tvShow
        setUpViews()
        populateDetails()
        observeSimilarShows()
    }

    private fun observeSimilarShows() {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewmodel.getSimilartvShows(tvShow.id.toInt()).collectLatest { data ->
                similarTvShowAdapter.submitData(data)
            }
        }
    }

    private fun populateDetails() {
        binding.layoutSimilarShow.apply {
            showName.text = tvShow.name
            showRating.text = tvShow.vote_average.toString()
            showPoster.load("$IMAGE_BASE${tvShow.poster_path}") {
                placeholder(R.drawable.loading_animation)
            }
        }
    }

    private fun setUpViews() {
        binding.rvSimilarShows.apply {
            addItemDecoration(
                DividerItemDecoration(
                    context,
                    DividerItemDecoration.VERTICAL
                )
            )
            adapter = similarTvShowAdapter
            adapter = similarTvShowAdapter.withLoadStateHeaderAndFooter(
                header = ShowLoadingAdapter { similarTvShowAdapter.retry() },
                footer = ShowLoadingAdapter { similarTvShowAdapter.retry() }
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}