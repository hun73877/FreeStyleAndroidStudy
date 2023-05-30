package com.season.winter.common.util.random

import android.util.Log
import kotlin.random.Random

fun getRandomNumber(
    minValue: Int = 10,
    maxValue: Int = 20
): Int {
    require(minValue <= maxValue) {
        Log.e("TAG", "getRandomNumber: maxValue가 minValue보다 크거나 같아야 합니다.")
        return 0
    }
    return Random.nextInt(minValue, maxValue + 1)
}