package com.thingthing.thatthing.ui.details

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.thingthing.thatthing.R
import com.thingthing.thatthing.databinding.SimilarShowItemBinding
import com.thingthing.thatthing.model.TvShow
import com.thingthing.thatthing.utils.IMAGE_BASE
import com.thingthing.thatthing.utils.TvShowDiffUtilCallBack

class SimilarTvShowAdapter :
    PagingDataAdapter<TvShow, SimilarTvShowAdapter.SimilarTvShowViewHolder>(TvShowDiffUtilCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimilarTvShowViewHolder {
        val binding = SimilarShowItemBinding.inflate(LayoutInflater.from(parent.context))
        return SimilarTvShowViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SimilarTvShowViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    class SimilarTvShowViewHolder(private val binding: SimilarShowItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(tvShow: TvShow) {
            binding.showName.text = tvShow.name
            binding.showRating.text = tvShow.vote_average.toString()
            binding.showPoster.load("$IMAGE_BASE${tvShow.poster_path}") {
                placeholder(R.drawable.loading_animation)
            }
        }
    }
}