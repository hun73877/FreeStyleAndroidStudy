package com.season.winter.freerecyclerview.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import com.season.winter.common.extention.imageView.setUrl
import com.season.winter.dummydata.model.MixedDummyData
import com.season.winter.freerecyclerview.databinding.ItemMyImageViewHolderBinding
import com.season.winter.freerecyclerview.viewholder.base.BaseMyViewHolder

class MyImageViewHolder(
    parent: ViewGroup,
    layoutInflater: LayoutInflater = LayoutInflater.from(parent.context),
    private val binding: ItemMyImageViewHolderBinding =
        ItemMyImageViewHolderBinding.inflate(layoutInflater, parent, false),
): BaseMyViewHolder(binding.root) {

    init {
        binding.run {
            viewHolder = this@MyImageViewHolder
        }
    }

    override fun bind(data: MixedDummyData) = binding.run {
        data.photoUrl?.run {
            imageView.setUrl(this)
        }
        index = adapterPosition.toString()
    }
}