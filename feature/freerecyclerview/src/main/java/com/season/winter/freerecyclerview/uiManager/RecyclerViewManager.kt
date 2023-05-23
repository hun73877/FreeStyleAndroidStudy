package com.season.winter.freerecyclerview.uiManager

import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.season.winter.common.extention.recyclerView.scrollToLast
import com.season.winter.common.extention.setOnClickListeners
import com.season.winter.freerecyclerview.R
import com.season.winter.freerecyclerview.adapter.MyAdapter
import com.season.winter.freerecyclerview.databinding.FragmentFreeStyleRecyclerViewBinding
import com.season.winter.freerecyclerview.databinding.FragmentRvBinding

class RecyclerViewManager(
    binding: FragmentFreeStyleRecyclerViewBinding,
    private val layoutInflater: LayoutInflater,
): OnClickListener {

    private val incBtn = binding.incBtn
    private val decBtn = binding.decBtn
    private val rvContainer = binding.rvContainer
    private var rv: RecyclerView? = null

    private val myAdapter = MyAdapter().apply {
        onAddedItem = { rv?.scrollToLast(itemCount) }
    }

    init {
        attachRv()
        setRv()
        setInitialData()
        setOnClickListeners(incBtn, decBtn)
    }

    private fun attachRv() = createRv().apply {
        rvContainer.addView(root)
        this@RecyclerViewManager.rv = rv
    }

    fun detachRv() {
        rvContainer.removeAllViews()
        rv = null
    }

    private fun setRv() = rv?.run { adapter = myAdapter }

    private fun setInitialData() = myAdapter.initData(
        listOf("1", "2", "3", "4", "5", "6", "7", "8",)
    )

    override fun onClick(view: View?) {
        when(view ?: return) {
            incBtn -> myAdapter.addNewData()
            decBtn -> myAdapter.removeLastData()
        }
    }

    private fun createRv(): FragmentRvBinding =
        DataBindingUtil.inflate(
            layoutInflater,
            R.layout.fragment_rv,
            rvContainer,
            false
        )
}