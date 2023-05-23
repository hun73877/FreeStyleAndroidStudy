package com.season.winter.freerecyclerview.viewholder

import androidx.recyclerview.widget.DiffUtil

class StringDiffCallback: DiffUtil.ItemCallback<String>() {

    override fun areItemsTheSame(oldItem: String, newItem: String): Boolean =
        oldItem == newItem

    override fun areContentsTheSame(oldItem: String, newItem: String): Boolean =
        oldItem == newItem
}