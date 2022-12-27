package com.example.composeexamplev3.common.presentation.common

import androidx.lifecycle.MutableLiveData
import com.example.composeexamplev3.data.common.ApiResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch

suspend fun <T> Flow<T>.customCollect(mutableLiveDataPosts: MutableLiveData<ApiResponse<T>>) {
    mutableLiveDataPosts.setLoading()
    catch {
        mutableLiveDataPosts.setError(it)
    }.collect{
        mutableLiveDataPosts.setSuccess(it)
    }
}