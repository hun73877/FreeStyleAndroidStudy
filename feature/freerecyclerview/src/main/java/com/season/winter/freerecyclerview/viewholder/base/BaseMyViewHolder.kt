package com.season.winter.freerecyclerview.viewholder.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.season.winter.dummydata.model.MixedDummyData

abstract class BaseMyViewHolder(view: View): RecyclerView.ViewHolder(view) {

    var onClickRemove: ((index: Int) -> Unit)? = null

    fun onClickRemove() = onClickRemove?.invoke(adapterPosition)

    abstract fun bind(data: MixedDummyData)
}