package com.season.winter.codestylereview

import com.season.winter.codestylereview.databinding.ActivityMainBinding
import com.season.winter.common.activity.BaseActivity
import com.season.winter.common.extention.activity.onBackPressedCallback
import com.season.winter.common.extention.fragmentActivity.currentFragment
import com.season.winter.common.extention.fragmentActivity.startFragment
import com.season.winter.freerecyclerview.fragment.freeStyleRecyclerView.FreeStyleRecyclerViewFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity: BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    override fun ActivityMainBinding.initView() {
        startFragment(
            recyclerViewContainer,
            FreeStyleRecyclerViewFragment.newInstance()
        )
        onBackPressedCallback()
    }

    private fun onBackPressedCallback() = onBackPressedCallback {
        when(currentFragment(binding.recyclerViewContainer)) {
            is FreeStyleRecyclerViewFragment -> finish()
            else -> {}
        }
    }
}