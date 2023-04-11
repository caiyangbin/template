package com.common.template.ui

import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.common.baselibrary.base.BaseBindingActivity
import com.egreat.template.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseBindingActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    private val viewModel: MainViewModel by viewModels()

    private lateinit var adapter: TestAdapter

    override fun initView() {
        adapter = TestAdapter()
        binding.rvTest.adapter = adapter
        binding.rvTest.layoutManager = GridLayoutManager(this, 5)

        val list = ArrayList<String>()
        repeat(300) {
            list.add("Item-$it")
        }
        adapter.setList(list, true)
    }

    override fun initEvent() {
    }

    override fun initData() {
        lifecycleScope.launchWhenStarted {
            viewModel.state.collect {
                Log.i("cyb", "onCreate: $it")
            }
        }
    }
}