package com.example.composeexamplev3.presentation.ui.post

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.lifecycle.MutableLiveData
import com.example.composeexamplev3.data.remote.post.entites.PostResponse
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostActivity : ComponentActivity() {

    private val postViewModel : PostViewModel by viewModels()
    private val postsModels = MutableLiveData<PostResponse>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            showPosts(postsModels)
        }
        init()
        setObservers()
    }

    private fun init() {

    }

    private fun setObservers() {
        postViewModel.getPosts()
    }
}

@Composable
fun showPosts(mutableLiveDataPosts: MutableLiveData<PostResponse>) {

}