package com.season.winter.freerecyclerview.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import com.season.winter.common.extention.imageView.setUrl
import com.season.winter.dummydata.model.MixedDummyData
import com.season.winter.freerecyclerview.databinding.ItemMyMixedViewHolderBinding
import com.season.winter.freerecyclerview.viewholder.base.BaseMyViewHolder

class MyMixedViewHolder(
    parent: ViewGroup,
    layoutInflater: LayoutInflater = LayoutInflater.from(parent.context),
    private val binding: ItemMyMixedViewHolderBinding =
        ItemMyMixedViewHolderBinding.inflate(layoutInflater, parent, false),
): BaseMyViewHolder(binding.root) {

    init {
        binding.run {
            viewHolder = this@MyMixedViewHolder
        }
    }

    override fun bind(data: MixedDummyData) = binding.run {
        data.photoUrl?.run { imageView.setUrl(this)    }
        text = data.contents
        index = adapterPosition.toString()
    }
}