package com.thingthing.thatthing.utils

import androidx.recyclerview.widget.DiffUtil
import com.thingthing.thatthing.model.TvShow

class TvShowDiffUtilCallBack : DiffUtil.ItemCallback<TvShow>() {
    override fun areItemsTheSame(oldItem: TvShow, newItem: TvShow): Boolean = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: TvShow, newItem: TvShow): Boolean {
        return oldItem.id == newItem.id &&
            oldItem.name == newItem.name
    }
}