package com.example.moviesDemo.ui.movies

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.moviesDemo.data.Movie
import com.example.moviesDemo.ui.ui.theme.ComposeExampleV3Theme

class MovieDetailActivity : ComponentActivity() {

    companion object {
        const val EXTRAS_MOVIE = "extras_movie"
        fun start(activity: Activity, movie: Movie) {
            activity.startActivity(
                Intent(activity, MovieDetailActivity::class.java).putExtra(
                    EXTRAS_MOVIE,
                    movie
                )
            )
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeExampleV3Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    intent.getParcelableExtra<Movie>(EXTRAS_MOVIE)?.let { movieDetail(movie = it) }
                }
            }
        }
    }
}

@Composable
fun movieDetail(movie: Movie) {
    LazyColumn(content = {
        item {
            Image(
                painter = painterResource(id = movie.moviePoster),
                contentDescription = movie.movieName,
                Modifier
                    .fillMaxWidth()
                    .height(400.dp)
                    .padding(16.dp),
                contentScale = ContentScale.Crop,
                alignment = Alignment.TopStart
            )
            Spacer(modifier = Modifier.size(20.dp))
            Text(
                text = movie.movieName,
                Modifier
                    .wrapContentWidth()
                    .wrapContentHeight()
                    .padding(start = 10.dp),
                style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold)
            )
            Spacer(modifier = Modifier.size(10.dp))

        }
    })
}