package com.example.composeexamplev3.presentation.ui.post

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composeexamplev3.data.common.ApiResponse
import com.example.composeexamplev3.data.remote.post.entites.PostResponse
import com.example.composeexamplev3.domain.post.IPostRepositary
import com.example.composeexamplev3.presentation.common.customCollect
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(val repositary: IPostRepositary) : ViewModel() {

    val mutableLiveDataPosts = MutableLiveData<ApiResponse<PostResponse>>()

    fun getPosts() {
        viewModelScope.launch {
            repositary.getPosts().customCollect(mutableLiveDataPosts)
        }
    }

}

