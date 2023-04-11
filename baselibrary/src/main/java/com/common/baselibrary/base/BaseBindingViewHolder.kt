package com.common.baselibrary.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

/**
 * Create by admin on 2022-01-04-10:09
 */
class BaseBindingViewHolder<VB : ViewBinding>(
  val binding: VB
) : RecyclerView.ViewHolder(binding.root) {
  constructor(parent: ViewGroup, inflate: (LayoutInflater, ViewGroup, Boolean) -> VB) :
      this(inflate(LayoutInflater.from(parent.context), parent, false))
}