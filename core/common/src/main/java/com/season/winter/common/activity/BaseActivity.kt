package com.season.winter.common.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.lifecycleScope

abstract class BaseActivity<T : ViewDataBinding>(
    private val layoutResourceId: Int
): AppCompatActivity() {

    protected val tag = this::class.java.simpleName.toString()

    lateinit var binding: T

    protected abstract fun T.initView()

    protected val coroutine = lifecycleScope

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutResourceId)
        binding.initView()
    }
}