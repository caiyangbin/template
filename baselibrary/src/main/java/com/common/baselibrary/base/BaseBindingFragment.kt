package com.common.baselibrary.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

/**
 * Create by admin on 2022-01-04-9:55
 */
abstract class BaseBindingFragment<VB : ViewBinding>(
    private val inflater: (LayoutInflater) -> VB
) : Fragment() {

    private var _binding: VB? = null
    val binding get() = _binding!!

    private var lastView: View? = null
    private var isNavigationViewInit = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // 防止重复创建view
        if (lastView == null) {
            _binding = inflater(layoutInflater)
            lastView = _binding?.root
        }
        return lastView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (!isNavigationViewInit) {
            isNavigationViewInit = true
            initView()
            initEvent()
            initData()
        }
    }

    abstract fun initView()

    abstract fun initEvent()

    abstract fun initData()

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}