package com.season.winter.dummydata.model

import com.season.winter.dummydata.generator.MixedDummyGenerator
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

data class MixedDummyData(
    val type: MixedType,
    val contents: String? = null,
    val photoUrl: String? = null,
) {

    var onResultList: ((result: List<MixedDummyData>) -> Unit)? = null
    var onResultData: ((result: MixedDummyData) -> Unit)? = null

    private val generator = MixedDummyGenerator()
    private val flow = MutableStateFlow<List<MixedDummyData>>(emptyList())

    init {
        subscribeToEvents()
    }

    private fun subscribeToEvents() = runBlocking {
        launch {
            flow.collect { value ->
                onResultList?.invoke(value)
            }
        }
    }

    fun getRandomData() = onResultData?.invoke(
        generator.getRandomData()
    )

    fun getNewRandomList() = flow.run {
        map { generator.getRandomList() }
        onEach {
            value = it
        }
    }

    companion object {

        fun instance() =
            MixedDummyData(MixedType.Text)
    }
}