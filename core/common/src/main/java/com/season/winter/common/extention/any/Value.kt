package com.season.winter.common.extention.any


val Any?.isNotNull get() = this != null
val Any?.isNull get() = this == null