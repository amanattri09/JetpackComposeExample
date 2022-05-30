package com.example.moviesDemo.ui.movies2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.basicrecyclerviewexample.utils.getActionMovieList
import com.example.moviesDemo.data.Movie
import com.example.moviesDemo.ui.movies.MovieDetailActivity
import com.example.moviesDemo.ui.movies2.ui.theme.ComposeExampleV3Theme

class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeExampleV3Theme {
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = MaterialTheme.colors.background
                ) {
                    LazyColumn(content = {
                        item {
                            GenreTitle(text = "Action Thriller")
                            MoviesList(listMovies = getActionMovieList(), onClick = { movie ->
                                MovieDetailActivity.start(this@MainActivity2, movie)
                            })
                        }
                    })
                }
            }
        }
    }
}

@Composable
fun GenreTitle(text: String) {
    Text(
        text = text,
        Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(16.dp),
        style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold)
    )
}

@Composable
fun MoviesList(listMovies: List<Movie>, onClick: (Movie) -> Unit) {
    LazyRow(content = {
        items(listMovies) { movie ->
            movieItemView(movie, onClick)
        }
    })
}

@Composable
fun movieItemView(movie: Movie, onClick: (Movie) -> Unit) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
        .clickable {
            onClick.invoke(movie)
        }
        .width(150.dp)
        .wrapContentHeight()) {
        Image(
            painter = painterResource(id = movie.moviePoster),
            contentDescription = movie.movieName,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(5.dp)
        )
        Text(
            text = movie.movieName,
            style = TextStyle(fontSize = 12.sp, fontWeight = FontWeight.Bold)
        )
        Text(
            text = movie.movieName,
            style = TextStyle(fontSize = 12.sp, fontWeight = FontWeight.Bold)
        )
    }
}