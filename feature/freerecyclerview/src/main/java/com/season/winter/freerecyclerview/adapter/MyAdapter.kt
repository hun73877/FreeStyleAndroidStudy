package com.season.winter.freerecyclerview.adapter

import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import com.season.winter.freerecyclerview.viewholder.MyViewHolder
import androidx.recyclerview.widget.ListAdapter
import com.season.winter.freerecyclerview.viewholder.StringDiffCallback

object MyAdapterType {
    const val A = 0
    const val B = 1
}

class MyAdapter: ListAdapter<String, RecyclerView.ViewHolder>(StringDiffCallback()) {

    var onAddedItem: (() -> Unit)? = null

    override fun getItemCount(): Int = currentList.size

    override fun getItemViewType(position: Int): Int = MyAdapterType.A

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when(viewType) {
            MyAdapterType.A -> MyViewHolder.create(parent)
            else  -> MyViewHolder.create(parent)
        }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) =
        when (holder) {
            is MyViewHolder -> {
                holder.run {
                    bind(currentList[position])
                    onClickRemove = { removeData(position) }
                }
            }
            else -> {}
        }

    fun initData(data: List<String>) = submitList(data)

    fun addNewData() {
        val last = currentList.lastOrNull()
        val newData = currentList.toMutableList()

        if (last == null)
            newData.add("0")
        else
            newData.add((last.toInt() + 1).toString())

        submitList(newData)
        onAddedItem?.invoke()
    }

    fun removeLastData() {
        val newData = currentList.toMutableList()
        newData.removeLastOrNull()
        submitList(newData)
    }

    private fun removeData(index: Int) {
        if (currentList.isEmpty()) return
        val newData = currentList.toMutableList()
        newData.removeAt(index)
        submitList(newData)
    }
}

