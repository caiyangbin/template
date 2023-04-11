package com.common.template.ui

import com.common.baselibrary.base.BaseTvAdapter
import com.egreat.template.databinding.ItemTestBinding

class TestAdapter:BaseTvAdapter<String,ItemTestBinding>(ItemTestBinding::inflate) {
    override fun setData(binding: ItemTestBinding, data: String, position: Int) {
        binding.tvTest.text = data
    }
}