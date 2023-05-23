package com.season.winter.codestylereview

import com.season.winter.codestylereview.databinding.ActivityMainBinding
import com.season.winter.common.activity.BaseActivity
import com.season.winter.common.fragment.CustomFragmentManager
import com.season.winter.freerecyclerview.fragment.FreeStyleRecyclerViewFragment

class MainActivity: BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    private var fm: CustomFragmentManager? = null

    override fun initStartView() {
        fm = CustomFragmentManager(this, binding.fragmentContainerLayout)
    }

    override fun ActivityMainBinding.initAfterView() {
        fm?.startFragment(FreeStyleRecyclerViewFragment.newInstance())
    }

    override fun onBackButtonPressed() {
        super.onBackButtonPressed()
        when(fm?.currentFragment()) {
            is FreeStyleRecyclerViewFragment -> finish()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        fm = null
    }
}