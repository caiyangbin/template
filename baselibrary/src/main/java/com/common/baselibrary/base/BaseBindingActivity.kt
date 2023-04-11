package com.common.baselibrary.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

/**
 * Create by admin on 2022-01-04-9:52
 */

abstract class BaseBindingActivity<VB : ViewBinding>(
    private val inflater: (LayoutInflater) -> VB
) : AppCompatActivity() {

    lateinit var binding: VB

    override fun onCreate(savedInstanceState: Bundle?) {
        // 参数一：当前页面进入动画，参数二：上个页面退出动画
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        super.onCreate(savedInstanceState)
        binding = inflater(layoutInflater)
        setContentView(binding.root)
        initView()
        initEvent()
        initData()
    }

    abstract fun initView()

    abstract fun initEvent()

    abstract fun initData()

    override fun finish() {
        super.finish()
        // 参数一：下个页面进入动画，参数二：当前页面退出动画
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
    }

}