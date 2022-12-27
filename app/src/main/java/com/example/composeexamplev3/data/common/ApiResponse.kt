package com.example.composeexamplev3.data.common

import com.example.composeexamplev3.common.network.ApiService

sealed class ApiResponse<out T>{

    object Loading : ApiResponse<Nothing>()

    class Error constructor(error : Throwable) : ApiResponse<Nothing>()

    class Success<out T>(val data : T) : ApiResponse<T>()

}
