package com.common.template.domain

import com.common.baselibrary.core.Resource
import kotlinx.coroutines.flow.Flow

interface MainRepository {

    fun getHomeData():List<String>

}