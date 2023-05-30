package com.season.winter.freerecyclerview.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.season.winter.dummydata.model.MixedDummyData
import com.season.winter.freerecyclerview.databinding.ItemMyTextViewHolderBinding
import com.season.winter.freerecyclerview.viewholder.base.BaseMyViewHolder

class MyTextViewHolder(
    parent: ViewGroup,
    layoutInflater: LayoutInflater = LayoutInflater.from(parent.context),
    private val binding: ItemMyTextViewHolderBinding =
        ItemMyTextViewHolderBinding.inflate(layoutInflater, parent, false),
): BaseMyViewHolder(binding.root) {

    init {
        binding.run {
            viewHolder = this@MyTextViewHolder
        }
    }

    override fun bind(data: MixedDummyData) = binding.run {
        index = adapterPosition.toString()
        text = data.contents
    }
}