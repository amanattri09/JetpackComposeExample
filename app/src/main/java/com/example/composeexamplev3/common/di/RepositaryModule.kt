package com.example.composeexamplev3.common.di

import com.example.composeexamplev3.data.remote.post.repo.PostRepositary
import com.example.composeexamplev3.domain.post.IPostRepositary
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepositaryModule {

    @Provides
    fun providePostRepo(postRepositary: PostRepositary): IPostRepositary = postRepositary

}