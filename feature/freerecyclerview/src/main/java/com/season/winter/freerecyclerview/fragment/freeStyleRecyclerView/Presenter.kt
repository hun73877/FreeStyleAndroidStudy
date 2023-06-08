package com.season.winter.freerecyclerview.fragment.freeStyleRecyclerView

import com.season.winter.common.util.LayoutManagerType
import com.season.winter.dummydata.model.MixedDummyData

class Presenter(
//    private val context: Context,
//    private val binding: FragmentFreeStyleRecyclerViewBinding,
) {

    private var lastState = LayoutManagerType.Linear

    var onResultList: ((result: List<MixedDummyData>) -> Unit)? = null
    var onResultData: ((result: MixedDummyData) -> Unit)? = null
    var onNewLayoutManager: ((type: LayoutManagerType) -> Unit)? = null

    private val model = MixedDummyData.instance().apply {
        onResultList = { list ->
            this@Presenter.onResultList?.invoke(list)
        }
        onResultData = { data ->
            this@Presenter.onResultData?.invoke(data)
        }
    }

    fun getNewList() = model.getNewRandomList()
    fun add() = model.getRandomData()

    fun changeLayoutManager(type: LayoutManagerType) {
        if (type.isSameState(lastState)) return
        else lastState = type
        onNewLayoutManager?.invoke(lastState)
    }
}