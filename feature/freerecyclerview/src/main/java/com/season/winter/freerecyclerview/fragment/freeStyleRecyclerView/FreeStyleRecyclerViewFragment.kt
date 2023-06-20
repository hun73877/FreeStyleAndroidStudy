package com.season.winter.freerecyclerview.fragment.freeStyleRecyclerView

import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.season.winter.common.extention.recyclerView.scrollToLast
import com.season.winter.common.util.LayoutManagerType
import com.season.winter.common.fragment.BaseFragment
import com.season.winter.freerecyclerview.R
import com.season.winter.freerecyclerview.adapter.MyTextAdapter
import com.season.winter.freerecyclerview.databinding.FragmentFreeStyleRecyclerViewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FreeStyleRecyclerViewFragment:
    BaseFragment<FragmentFreeStyleRecyclerViewBinding>(R.layout.fragment_free_style_recycler_view)
{

    // private val viewModel = ViewModelProvider(this)[FreeStyleRecyclerViewViewModel::class.java]
    private val viewModel: FreeStyleRecyclerViewViewModel by viewModels()

    init {
        viewModel.apply {
            coroutine.launchWhenStarted {
                onResultListFlow.collect { list ->
                    binding.adapter?.initData(list)
                }
            }
            coroutine.launchWhenStarted {
                onResultDataFlow.collect { data ->
                    val result = data ?: return@collect
                    binding.adapter?.addLast(result)
                }
            }
            coroutine.launchWhenStarted {
                onNewLayoutManagerFlow.collect { layoutManagerType ->
                    context?.run {
                        binding.layoutManager = layoutManagerType.getLayoutManager(this)
                    }

                }
            }
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
        coroutine.launch {
            viewModel.getNewList()
        }
    }

    fun changeLayoutManager(type: LayoutManagerType) {
        coroutine.launch {
            viewModel.changeLayoutManager(type)
        }
    }

    fun resetNewRandomList() {
        coroutine.launch {
            viewModel.getNewList()
        }
    }

    fun add() {
        viewModel.add()
    }

    companion object {

        fun newInstance() =
            FreeStyleRecyclerViewFragment()
    }
}