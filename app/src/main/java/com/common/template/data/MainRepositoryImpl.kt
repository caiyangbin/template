package com.common.template.data

import android.util.Log
import com.common.template.domain.MainRepository
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor() : MainRepository {

    override fun getHomeData(): List<String>  {
        Log.i("cyb", "getHomeData: start")
        Log.i("cyb", "getHomeData: end")
        throw Exception("我是异常")
    }
}