package com.example.composeexamplev3.presentation.common

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import com.example.composeexamplev3.data.common.ApiResponse


fun <T> MutableLiveData<ApiResponse<T>>.setSuccess(data: T) {
    return postValue(ApiResponse.Success(data))
}

fun <T> MutableLiveData<ApiResponse<T>>.setError(it: Throwable) {
    return postValue(ApiResponse.Error(it))
}

fun <T> MutableLiveData<ApiResponse<T>>.setLoading() {
    return postValue(ApiResponse.Loading)
}

fun <T> MutableLiveData<ApiResponse<T>>.customObserve(
    lifecycleOwner: LifecycleOwner,
    onLoading: (Boolean) -> Unit,
    onError: (Throwable) -> Unit,
    onSuccess : ((T) -> Unit)
) {
    this.observe(lifecycleOwner) {
        when(it){
            is ApiResponse.Loading->{
                onLoading.invoke(true)
            }
            is ApiResponse.Error->{
                onLoading.invoke(false)
                onError.invoke(it.error)
            }
            is ApiResponse.Success<T>->{
                onLoading.invoke(false)
                onSuccess.invoke(it.data)
            }
        }
    }
}
