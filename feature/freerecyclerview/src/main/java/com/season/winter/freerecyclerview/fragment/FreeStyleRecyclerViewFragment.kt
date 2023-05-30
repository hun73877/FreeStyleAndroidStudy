package com.season.winter.freerecyclerview.fragment

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import com.season.winter.common.extention.recyclerView.scrollToLast
import com.season.winter.common.util.LayoutManagerType
import com.season.winter.common.fragment.BaseFragment
import com.season.winter.dummydata.generator.MixedDummyGenerator
import com.season.winter.freerecyclerview.R
import com.season.winter.freerecyclerview.adapter.MyTextAdapter
import com.season.winter.freerecyclerview.databinding.FragmentFreeStyleRecyclerViewBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class FreeStyleRecyclerViewFragment:
    BaseFragment<FragmentFreeStyleRecyclerViewBinding>(R.layout.fragment_free_style_recycler_view)
{
    companion object {
        fun newInstance() = FreeStyleRecyclerViewFragment()
    }

    private var lastState = LayoutManagerType.Linear
    private val myDummyGenerator = MixedDummyGenerator()
    lateinit var myContext: Context

    override fun onAttach(context: Context) {
        super.onAttach(context)
        myContext = context.applicationContext
    }

    override fun initStartView() {
        binding.fragment = this
    }

    override fun FragmentFreeStyleRecyclerViewBinding.initAfterView() {
        layoutManager = LinearLayoutManager(myContext)
        adapter = MyTextAdapter().apply {
            onAdded = {
                coroutine.launch {
                    delay(100)
                    recyclerView.scrollToLast(itemCount)
                }
            }
        }
        resetData()
    }

    fun changeLayoutManager(type: LayoutManagerType) = binding.run {
        if (type.isSameState(lastState)) return@run
        else lastState = type
        layoutManager = type.getLayoutManager(myContext)
        adapter?.onAdded?.invoke()
    }

    fun resetData() = binding.run {
        coroutine.launch {
            val result = myDummyGenerator.getRandomList()
            adapter?.run {
                dummyGenerator = myDummyGenerator
                initData(result)
            }
        }
    }
}