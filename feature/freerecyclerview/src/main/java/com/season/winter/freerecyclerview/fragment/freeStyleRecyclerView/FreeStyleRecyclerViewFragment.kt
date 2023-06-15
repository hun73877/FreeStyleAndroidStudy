package com.season.winter.freerecyclerview.fragment.freeStyleRecyclerView

import androidx.recyclerview.widget.LinearLayoutManager
import com.season.winter.common.extention.recyclerView.scrollToLast
import com.season.winter.common.util.LayoutManagerType
import com.season.winter.common.fragment.BaseFragment
import com.season.winter.dummydata.generator.MixedDummyRepository
import com.season.winter.freerecyclerview.R
import com.season.winter.freerecyclerview.adapter.MyTextAdapter
import com.season.winter.freerecyclerview.databinding.FragmentFreeStyleRecyclerViewBinding

class FreeStyleRecyclerViewFragment:
    BaseFragment<FragmentFreeStyleRecyclerViewBinding>(R.layout.fragment_free_style_recycler_view)
{

    private val presenter = FreeStyleRecyclerViewPresenter(
        MixedDummyRepository()
    ).apply {
        onResultData = { data ->
            binding.adapter?.addLast(data)
        }
        onNewLayoutManager = { layoutManagerType ->
            context?.run {
                binding.layoutManager =
                    layoutManagerType.getLayoutManager(this)
            }
        }
        onResultListFlow.collect { list ->
            binding.adapter?.initData(list)
        }
    }

    override fun initStartView() {
        binding.fragment = this
    }

    override fun FragmentFreeStyleRecyclerViewBinding.initAfterView() {
        layoutManager = LinearLayoutManager(context)
        adapter = MyTextAdapter().apply {
            onAdded = {
                recyclerView.scrollToLast(itemCount)
            }
        }
        presenter.getNewList()
    }

    fun changeLayoutManager(type: LayoutManagerType) =
        presenter.changeLayoutManager(type)

    fun resetNewRandomList() =
        presenter.getNewList()

    fun add() =
        presenter.add()

    companion object {

        fun newInstance() =
            FreeStyleRecyclerViewFragment()
    }
}