package com.season.winter.common.extention.coroutine

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.isActive

fun CoroutineScope.cancelIfActive() {
    if (isActive) cancel()
}