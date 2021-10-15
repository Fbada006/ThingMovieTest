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

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.thingthing.thatthing.databinding.FragmentShowsBinding
import com.thingthing.thatthing.ui.TmdbViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class ShowsFragment : Fragment() {

    private val viewmodel by viewModels<TmdbViewModel>()
    private var _binding: FragmentShowsBinding? = null
    private val binding get() = _binding!!
    private val showAdapter = TvShowAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentShowsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpViews()
        fetchShows()
    }

    private fun fetchShows() {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewmodel.getAllShows().collectLatest {
                showAdapter.submitData(it)
            }
        }
    }

    private fun setUpViews() {
        binding.rvShows.apply {
            adapter = showAdapter
            adapter = showAdapter.withLoadStateHeaderAndFooter(
                header = ShowLoadingAdapter { showAdapter.retry() },
                footer = ShowLoadingAdapter { showAdapter.retry() }
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}