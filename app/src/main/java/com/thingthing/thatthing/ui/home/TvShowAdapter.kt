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
            binding.showPoster.load(tvShow.poster_path)
        }
    }
}