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
        inflater: LayoutInflater, container: ViewGroup?,
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
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}