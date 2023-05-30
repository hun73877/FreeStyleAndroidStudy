package com.season.winter.common.extention.fragmentActivity

import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentTransaction
import com.season.winter.common.R
import com.season.winter.common.extention.any.isNotNull
import java.lang.Exception

enum class FragmentTransactionAnimation {
    SLIDE_RIGHT_TO_LEFT,
    ;
}

fun FragmentActivity.startFragment(
    container: View,
    fragment: Fragment,
    animation: FragmentTransactionAnimation? = null,
    addBackStack: Boolean = true
) =
    supportFragmentManager.beginTransaction().run {
        animation?.run { addAnim(this) }
        if(addBackStack)
            addToBackStack(null)

        replace(container.id , fragment)
        try {
            commit()
        } catch (e: Exception) {
            Log.e("TAG", "Exception: startFragment: $e")
        }
    }

fun FragmentActivity.currentFragment(frameBase: View,): Fragment? =
    supportFragmentManager.findFragmentById(frameBase.id)

fun FragmentTransaction.addAnim(anim: FragmentTransactionAnimation): FragmentTransaction {
    return when(anim) {
        FragmentTransactionAnimation.SLIDE_RIGHT_TO_LEFT -> setCustomAnimations(
            R.anim.slide_right_in,
            R.anim.slide_left_out,
            R.anim.slide_left_in,
            R.anim.slide_right_out
        )
    }
}
