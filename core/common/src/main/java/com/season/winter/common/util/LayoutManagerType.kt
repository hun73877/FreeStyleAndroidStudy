package com.season.winter.common.util

import android.content.Context
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

enum class LayoutManagerType {
    Linear,
    Grid,
    Staggered
    ;

    fun isSameState(lastState: LayoutManagerType): Boolean = this == lastState

    fun getLayoutManager(
        context: Context,
        spanCount: Int = 2,
        orientation: Int = StaggeredGridLayoutManager.VERTICAL
    ): RecyclerView.LayoutManager =
        when (this) {
            Linear    -> LinearLayoutManager(context)
            Grid      -> GridLayoutManager(context, spanCount)
            Staggered -> StaggeredGridLayoutManager(spanCount, orientation)
        }
}