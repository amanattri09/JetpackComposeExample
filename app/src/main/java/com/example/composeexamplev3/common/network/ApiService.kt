package com.example.composeexamplev3.common.network

import com.example.composeexamplev3.data.remote.post.entites.PostResponse
import retrofit2.http.GET

interface ApiService {

    @GET("/posts")
    suspend fun getPosts(): PostResponse
}