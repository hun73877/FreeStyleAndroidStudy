package com.season.winter.common.extention.log

import android.util.Log
import kotlin.reflect.KClass

fun KClass<*>.loge(message: String) {
    Log.e(
        this::class.java.simpleName,
        message,
    )
}