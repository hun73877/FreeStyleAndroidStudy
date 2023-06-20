package com.season.winter.freerecyclerview.fragment.freeStyleRecyclerView

import androidx.lifecycle.ViewModel
import com.season.winter.common.util.LayoutManagerType
import com.season.winter.dummydata.generator.MixedDummyRepositoryImpl
import com.season.winter.dummydata.model.MixedDummyData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject
import kotlin.coroutines.Continuation
import kotlin.coroutines.coroutineContext

@HiltViewModel
class FreeStyleRecyclerViewViewModel @Inject constructor(
    val repository: MixedDummyRepositoryImpl,
): ViewModel() {

    private var lastState = LayoutManagerType.Linear

//    var onNewLayoutManager: ((type: LayoutManagerType) -> Unit)? = null
    var onNewLayoutManagerFlow = MutableSharedFlow<LayoutManagerType>()
    var onResultListFlow = MutableStateFlow<List<MixedDummyData>>(emptyList())
    var onResultDataFlow = MutableStateFlow<MixedDummyData?>(null)

    suspend fun getNewList() {
        onResultListFlow.value = repository.getRandomList()

        // callback
//        repository.getRandomList { list ->
//            onResultListFlow.value = list
//        }

        // continuation
//        val continuation = Continuation(coroutineContext) { coninuation ->
//            coninuation.onSuccess { result ->
//                onResultListFlow.value = result
//            }
//        }
//        repository.getRandomList(continuation)
    }

    fun add() {
        onResultDataFlow.value = repository.getRandomData()
    }

    suspend fun changeLayoutManager(type: LayoutManagerType) {
        if (type.isSameState(lastState)) return
        else lastState = type
        onNewLayoutManagerFlow.emit(lastState)
    }
}