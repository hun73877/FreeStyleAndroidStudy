package com.season.winter.freerecyclerview.fragment.freeStyleRecyclerView

import com.season.winter.common.util.LayoutManagerType
import com.season.winter.dummydata.generator.MixedDummyRepository
import com.season.winter.dummydata.model.MixedDummyData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach

class FreeStyleRecyclerViewPresenter(
    private val mixedDummyRepository: MixedDummyRepository,
) {

    private var lastState = LayoutManagerType.Linear

//    var onResultList: ((result: List<MixedDummyData>) -> Unit)? = null
    var onResultData: ((result: MixedDummyData) -> Unit)? = null
    var onNewLayoutManager: ((type: LayoutManagerType) -> Unit)? = null

    var onResultListFlow = MutableStateFlow<List<MixedDummyData>>(emptyList())

    fun getNewList() = onResultListFlow.run {
        map {
            mixedDummyRepository.getRandomList()
        }
        onEach {
            emit(it)
        }
    }
    fun add() = mixedDummyRepository.getRandomData()

    fun changeLayoutManager(type: LayoutManagerType) {
        if (type.isSameState(lastState)) return
        else lastState = type
        onNewLayoutManager?.invoke(lastState)
    }
}