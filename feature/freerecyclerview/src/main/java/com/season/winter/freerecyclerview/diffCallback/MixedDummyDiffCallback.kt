package com.season.winter.freerecyclerview.diffCallback

import androidx.recyclerview.widget.DiffUtil
import com.season.winter.dummydata.model.MixedDummyData

class MixedDummyDiffCallback: DiffUtil.ItemCallback<MixedDummyData>() {

    override fun areItemsTheSame(oldItem: MixedDummyData, newItem: MixedDummyData): Boolean =
        oldItem == newItem

    override fun areContentsTheSame(oldItem: MixedDummyData, newItem: MixedDummyData): Boolean =
        oldItem.contents == newItem.contents
}