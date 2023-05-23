package com.season.winter.common.fragment

import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

class CustomFragmentManager(
    private val context: FragmentActivity,
    private var frameBase: View
) {

    fun startFragment(fragment: Fragment) =
        context.supportFragmentManager.beginTransaction()
            .replace(frameBase.id , fragment)
            .addToBackStack(null)
            .commit()

    fun currentFragment(): Fragment? = context.supportFragmentManager.findFragmentById(frameBase.id)
}