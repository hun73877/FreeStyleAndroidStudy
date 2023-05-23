package com.season.winter.common.extention

import android.view.View
import android.view.View.OnClickListener

fun OnClickListener.setOnClickListeners(vararg views: View) =
    views.forEach { view -> view.setOnClickListener(this) }
