package com.example.composeexamplev3.presentation.ui.post

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.composeexamplev3.data.remote.post.entites.PostResponse
import com.example.composeexamplev3.presentation.common.base.BaseActivity
import com.example.composeexamplev3.presentation.common.constants.HomeScreen
import com.example.composeexamplev3.presentation.common.constants.PostDetailScreen
import com.example.composeexamplev3.presentation.common.customObserve
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostActivity : BaseActivity() {

    private val postViewModel: PostViewModel by viewModels()
    private val postsModels = mutableStateOf<PostResponse?>(null)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            postApp(postsModels)
        }
        setObservers()
        init()
    }

    private fun init() {
        postViewModel.getPosts()
    }

    private fun setObservers() {
        postViewModel.mutableLiveDataPosts.customObserve(
            this,
            onLoading = ::onLoading,
            onError = ::onError,
            onSuccess = {
                postsModels.value = it
            }
        )
    }
}

@Composable
fun postApp(mutableLiveDataPosts: MutableState<PostResponse?>) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = HomeScreen.ROUTE) {
        composable(route = HomeScreen.ROUTE) {
            postListScreen(mutableLiveDataPosts, navController)
        }
        composable(route = PostDetailScreen.ROUTE + "/{${PostDetailScreen.ARGUMENTS.POST_TITLE}}/{${PostDetailScreen.ARGUMENTS.POST_DISCRIPTION}}",
            arguments = listOf(
                navArgument(name = PostDetailScreen.ARGUMENTS.POST_TITLE) {
                    type = NavType.StringType
                },
                navArgument(name = PostDetailScreen.ARGUMENTS.POST_DISCRIPTION) {
                    type = NavType.StringType
                }
            )) {
            PostDetailScreen(
                navController,
                it.arguments?.getString(PostDetailScreen.ARGUMENTS.POST_TITLE),
                it.arguments?.getString(PostDetailScreen.ARGUMENTS.POST_DISCRIPTION)
            )
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun postListScreen(
    mutableLiveDataPosts: MutableState<PostResponse?>,
    navController: NavHostController
) {
    Scaffold(topBar = {
        TopAppBar(
            title = { Text(text = "Home") }
        )
    }, content = {
        LazyColumn(content = {
            mutableLiveDataPosts.value?.forEach {
                item {
                    Log.i(PostActivity::class.java.name, "inside item")
                    Text(text = it.title, modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp)
                        .padding(horizontal = 16.dp)
                        .clickable {
                            navController.navigate(PostDetailScreen.ROUTE + "/${it.title + "/" + it.body}")
                        })
                }
            }
        })
    })
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun PostDetailScreen(navController: NavHostController, title: String?, description: String?) {
    Scaffold(topBar = {
        TopAppBar(
            title = { Text(text = "Post Detail") } , navigationIcon = {
                IconButton(onClick = {
                    navController.navigateUp()
                }) {
                    Icon(Icons.Filled.ArrowBack,"backicon")
                }
            }
        ) }
    ) {
        Column(
            modifier = Modifier
                .wrapContentHeight()
                .padding(16.dp)
        ) {
            title?.let { title ->
                Text(text = "Title : $title", modifier = Modifier.fillMaxWidth())
            }
            description?.let { description ->
                Text(text = "Description : $description", modifier = Modifier.fillMaxWidth())
            }
        }
    }
}