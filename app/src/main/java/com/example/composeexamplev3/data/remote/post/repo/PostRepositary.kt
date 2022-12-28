package com.example.composeexamplev3.data.remote.post.repo

import com.example.composeexamplev3.common.network.ApiService
import com.example.composeexamplev3.data.remote.post.entites.PostResponse
import com.example.composeexamplev3.domain.post.IPostRepositary
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PostRepositary @Inject constructor(val apiService: ApiService): IPostRepositary {
    override suspend fun getPosts(): Flow<PostResponse> {
        return flow {
            emit(apiService.getPosts())
        }
    }
}