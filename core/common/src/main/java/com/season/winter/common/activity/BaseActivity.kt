package com.season.winter.common.activity

import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.season.winter.common.extention.coroutine.cancelIfActive
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

abstract class BaseActivity<T : ViewDataBinding>(
    private val layoutResourceId: Int
): AppCompatActivity() {

    val TAG by lazy { this::class.simpleName.toString() }

    private var viewDataBinding: T? = null
    val binding
        get() = viewDataBinding!!

    protected val baseUiCoroutine by lazy { CoroutineScope(SupervisorJob() + Dispatchers.Main) }

    protected var onBackPressed: (() -> Unit)? = null

    private val callback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() { onBackButtonPressed() }
    }

    protected abstract fun initStartView()
    protected abstract fun T.initAfterView()
    open fun onBackButtonPressed() { }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewDataBinding = DataBindingUtil.setContentView(this, layoutResourceId)

        initStartView()
        this.onBackPressedDispatcher.addCallback(this, callback)
        binding.initAfterView()
    }

    override fun onDestroy() {
        super.onDestroy()
        baseUiCoroutine.cancelIfActive()
        viewDataBinding = null
    }
}