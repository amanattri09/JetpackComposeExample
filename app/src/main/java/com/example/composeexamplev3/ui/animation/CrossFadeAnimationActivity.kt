package com.example.composeexamplev3.ui.animation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.composeexamplev3.ui.animation.ui.theme.ComposeExampleV3Theme

class CrossFadeAnimationActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeExampleV3Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    CrossFadeAnimationComponent()
                }
            }
        }
    }
}

@Composable
fun CrossFadeAnimationComponent() {
    val colors = listOf(Color.Red, Color.Green, Color.Blue, Color.Gray)
    var current by remember { mutableStateOf(colors[0]) }
    Column(modifier = Modifier.fillMaxSize()) {
        // Crossfade animation is used when there is change in the screen, like if there
        // is a transition between screens or there is a change in color of the screens or
        // something like that.
        // For example, here onClick of the Box, we are changing the background color of Box
        // by using Crossfade animation.
        Crossfade(targetState = current) { color ->
            Box(modifier = Modifier
                .fillMaxSize()
                .clickable {
                    current = colors.random()
                }
                .background(color))
            Text(text = "Click to see", Modifier.fillMaxSize(), textAlign = TextAlign.Center)
        }
    }
}