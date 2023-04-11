package com.common.baselibrary.base

import android.annotation.SuppressLint
import android.content.Context
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

/**
 * Create by Admin on 2020/1/4-16:36
 */
abstract class BaseMultipleItemTvAdapter<T, V : ViewBinding>(list: List<T>? = null) :
    RecyclerView.Adapter<BaseBindingViewHolder<V>>() {

    private val _list = ArrayList<T>()
    private var itemClickListener: ((View, Int, T) -> Unit)? = null
    private var itemSelectListener: ((View, Int, T) -> Unit)? = null
    private var itemFocusChangeListener: ((View, Boolean, Int, T) -> Unit)? = null
    private var itemKeyListener: ((View, Int, KeyEvent, T, Int) -> Boolean)? = null
    private var itemLongClickListener: ((View, Int, T) -> Boolean)? = null
    private var currentPosition = -1
    protected lateinit var context: Context

    init {
        // 当数据改变时，我们会调用 notifyDataSetChanged，这个时候列表会刷新，为了使 url 没变的 ImageView 不重新加载（图片会一闪）
        // 需要加上此属性
        this.setHasStableIds(true)
        list?.also {
            _list.clear()
            _list.addAll(it)
        }

    }


    // 当setHasStableIds(true)时，为了防止，数据重复错乱问题，需要复写getItemId方法
    override fun getItemId(position: Int): Long = position.toLong()

    fun setOnItemClickListener(listener: (view: View, position: Int, data: T) -> Unit) {
        this.itemClickListener = listener
    }

    fun setOnItemLongClickListener(listener: (view: View, position: Int, data: T) -> Boolean) {
        this.itemLongClickListener = listener
    }

    fun setOnItemFocusChangeListener(listener: (view: View, hasFocus: Boolean, position: Int, data: T) -> Unit) {
        this.itemFocusChangeListener = listener
    }

    fun setOnItemSelectListener(listener: (view: View, position: Int, data: T) -> Unit) {
        this.itemSelectListener = listener
    }

    fun setOnItemKeyListener(listener: (view: View, keyCode: Int, keyEvent: KeyEvent, data: T, position: Int) -> Boolean) {
        this.itemKeyListener = listener
    }

    fun getCurrentPosition(): Int = currentPosition

    override fun onBindViewHolder(
        holder: BaseBindingViewHolder<V>,
        @SuppressLint("RecyclerView") position: Int
    ) {
        with(holder.itemView) {
            _list[position].also { data ->
                // 设置数据
                setData(holder.binding, data, position)
                this.setOnClickListener {
                    // 设置item点击时间
                    itemClickListener?.invoke(it, position, data)
                }
                this.setOnKeyListener { view, keyCode, keyEvent ->
                    // 设置item键盘事件
                    itemKeyListener?.also {
                        return@setOnKeyListener it.invoke(view, keyCode, keyEvent, data, position)
                    }
                    return@setOnKeyListener false
                }
                this.setOnLongClickListener {
                    // 设置item长按事件
                    itemLongClickListener?.also {
                        return@setOnLongClickListener it.invoke(this, position, data)
                    }
                    return@setOnLongClickListener false
                }
                this.setOnFocusChangeListener { v, hasFocus ->
                    // 设置item焦点事件
                    itemFocusChangeListener?.invoke(v, hasFocus, position, data)
                    if (hasFocus) {
                        // 设置当前选择position
                        currentPosition = position
                        // 设置当前焦点item数据
                        setFocusData(holder.binding, data, position)
                        // 设置item选择事件
                        itemSelectListener?.invoke(v, position, data)
                    } else {
                        // 设置当前未获取焦点item数据
                        setNoFocusData(holder.binding, data, position)
                    }
                }
            }
        }
    }

    protected abstract fun setData(binding: V, data: T, position: Int)

    open fun setFocusData(binding: V, data: T, position: Int) {

    }

    open fun setNoFocusData(binding: V, data: T, position: Int) {

    }

    fun insertItemFromIndex(position: Int, t: T) {
        getList().add(position + 1, t)
        notifyItemInserted(position + 1)
        notifyItemRangeChanged(position + 1, getList().size - 1)
    }

    fun insertItem(t: T) {
        getList().add(t)
        notifyItemInserted(getList().size - 1)
    }

    fun removeItem(position: Int) {
        getList().removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, getList().size - 1)
    }

    fun changeItem(position: Int, t: T) {
        getList()[position] = t
        notifyItemChanged(position)
    }


    fun setList(list: List<T>, refresh: Boolean) {
        if (refresh) {
            // 清除旧数据
            val count = this._list.size - 1
            this._list.clear()
            notifyItemRangeRemoved(0, count)
            // 增加新数据
            this._list.addAll(list)
            notifyItemRangeInserted(0, _list.size - 1)
            notifyItemRangeChanged(0, _list.size - 1)
        }
    }

    fun getList(): ArrayList<T> {
        return this._list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseBindingViewHolder<V> {
        context = parent.context
        return BaseBindingViewHolder(parent, inflater(viewType))
    }

    abstract fun inflater(viewType: Int): (LayoutInflater, ViewGroup, Boolean) -> V

    override fun getItemCount(): Int = _list.size

}