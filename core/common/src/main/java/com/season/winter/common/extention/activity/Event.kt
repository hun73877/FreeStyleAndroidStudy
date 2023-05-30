package com.season.winter.common.extention.activity

import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity

fun AppCompatActivity.onBackPressedCallback(onBackPressed: () -> Unit) =
    onBackPressedDispatcher.addCallback(this,
        object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() = onBackPressed()
        }
    )

fun AppCompatActivity.onBackButtonPressed() =
    onBackPressedDispatcher.onBackPressed()