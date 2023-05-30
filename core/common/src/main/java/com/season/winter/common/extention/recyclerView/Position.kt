package com.season.winter.common.extention.recyclerView

import androidx.recyclerview.widget.RecyclerView

fun RecyclerView.scrollToLast(itemCount: Int) {
    scrollToPosition(itemCount - 1)
}