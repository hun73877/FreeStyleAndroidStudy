package com.season.winter.freerecyclerview.adapter

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import com.season.winter.freerecyclerview.viewholder.MyTextViewHolder
import androidx.recyclerview.widget.ListAdapter
import com.season.winter.dummydata.model.MixedDummyData
import com.season.winter.dummydata.model.MixedType
import com.season.winter.freerecyclerview.diffCallback.MixedDummyDiffCallback
import com.season.winter.freerecyclerview.viewholder.MyImageViewHolder
import com.season.winter.freerecyclerview.viewholder.MyMixedViewHolder
import com.season.winter.freerecyclerview.viewholder.base.BaseMyViewHolder

class MyTextAdapter: ListAdapter<MixedDummyData, RecyclerView.ViewHolder>(MixedDummyDiffCallback()) {

    var onAdded: (() -> Unit)? = null

    override fun getItemCount(): Int = currentList.size

    override fun getItemViewType(position: Int): Int = currentList[position].type.intType()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when(viewType) {
            MixedType.Text.intType()  -> MyTextViewHolder(parent)
            MixedType.Photo.intType() -> MyImageViewHolder(parent)
            else -> MyTextViewHolder(parent)
        }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is MyTextViewHolder -> holder.bind(currentList[position])
            is MyImageViewHolder -> holder.bind(currentList[position])
            is MyMixedViewHolder -> holder.bind(currentList[position])
            else -> {}
        }
        if (holder is BaseMyViewHolder)
            holder.onClickRemove = { index -> remove(index) }
    }

    fun initData(list: List<MixedDummyData>) {
        submitList(list)
    }

    fun addLast(data: MixedDummyData) = currentList.toMutableList().run {
        add(data)
        submitList(this)
    }

    fun removeLast() = currentList.toMutableList().run {
        removeLastOrNull()
        submitList(this)
    }

    private fun remove(index: Int) = currentList.run {
        if (isEmpty()) return@run
        try {
            toMutableList().run {
                removeAt(index)
                submitList(this)
            }
        } catch (e: ArrayIndexOutOfBoundsException) {
            Log.e("TAG", "removeData: e: $e", )
        }
    }

    override fun onCurrentListChanged(
        previousList: MutableList<MixedDummyData>,
        currentList: MutableList<MixedDummyData>
    ) {
        super.onCurrentListChanged(previousList, currentList)
        if (previousList != currentList)
            onAdded?.invoke()
    }
}

