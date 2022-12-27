package com.example.composeexamplev3.domain.post

import com.example.composeexamplev3.data.remote.post.entites.PostResponse
import kotlinx.coroutines.flow.Flow

interface IPostRepositary {
    suspend fun getPosts() : Flow<PostResponse>
}