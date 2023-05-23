package com.season.winter.freerecyclerview.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.season.winter.freerecyclerview.databinding.ItemMyViewHolderBinding

class MyViewHolder(private val binding: ItemMyViewHolderBinding): RecyclerView.ViewHolder(binding.root) {

    var onClickRemove: (() -> Unit)? = null

    init {
        binding.rmBtn.setOnClickListener {
            onClickRemove?.invoke()
        }
    }

    fun bind(data: String) = itemView.run {
        binding.run {
            tv.text = data
            rmBtn.text = "remove $data"
        }
    }

    companion object {
        fun create(
            parent: ViewGroup
        ): MyViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val view = ItemMyViewHolderBinding.inflate(layoutInflater, parent, false)
            return MyViewHolder(view)
        }
    }
}