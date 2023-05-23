package com.season.winter.freerecyclerview.fragment

import com.season.winter.common.fragment.BaseFragment
import com.season.winter.freerecyclerview.R
import com.season.winter.freerecyclerview.uiManager.RecyclerViewManager
import com.season.winter.freerecyclerview.databinding.FragmentFreeStyleRecyclerViewBinding

class FreeStyleRecyclerViewFragment: BaseFragment<FragmentFreeStyleRecyclerViewBinding>(R.layout.fragment_free_style_recycler_view) {

    companion object { fun newInstance() = FreeStyleRecyclerViewFragment() }

    private var rvManager: RecyclerViewManager? = null

    override fun initStartView() {
        rvManager = RecyclerViewManager(binding, layoutInflater)
    }

    override fun FragmentFreeStyleRecyclerViewBinding.initAfterView() {

    }

    override fun onDestroyView() {
        super.onDestroyView()
        rvManager?.detachRv()
        rvManager = null
    }
}