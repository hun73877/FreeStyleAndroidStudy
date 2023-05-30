package com.season.winter.dummydata.model

import com.season.winter.common.util.random.getRandomNumber

data class MixedDummyData(
    val type: MixedType,
    val contents: String? = null,
    val photoUrl: String? = null,
)

enum class MixedType {
    Text,
    Photo,
    Mixed
    ;

    fun intType(): Int =
        when(this) {
            Text  -> 0
            Photo -> 1
            Mixed -> 2
        }

    companion object {
        fun getRandom(): MixedType =
            when(getRandomNumber(0, 2)) {
                0    -> Text
                1    -> Photo
                else -> Mixed
            }
    }
}
