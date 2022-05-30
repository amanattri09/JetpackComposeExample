package com.example.animation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.animation.ui.theme.ComposeExampleV3Theme

class AnimationActivityDemo1 : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeExampleV3Theme {
                animationDemoBySize()
            }
        }
    }
}

private enum Class BoxState{
    Small,
    Big
}


@Composable
fun animationDemoBySize() {
    //lets declare state variable
    val boxState by remember{
        mutableStateOf(BoxState.Small)
    }
    val transition = updateTransition(boxState)
    val color by animateColorAsState(if (isBlue) Color.Blue else Color.Red)
    Column(Modifier.padding(16.dp)) {
        Button(onClick = { isBlue = !isBlue }) {
            Text(text = "Change Color")
        }
        Spacer(modifier = Modifier.height(15.dp))
        Box(
            modifier = Modifier
                .size(120.dp)
                .background(color)
        )
    }
}

@Composable
fun animationDemoByColor() {
    //lets declare state variable
    var isBlue by remember {
        mutableStateOf(true)
    }
    val color by animateColorAsState(if (isBlue) Color.Blue else Color.Red)
    Column(Modifier.padding(16.dp)) {
        Button(onClick = { isBlue = !isBlue }) {
            Text(text = "Change Color")
        }
        Spacer(modifier = Modifier.height(15.dp))
        Box(
            modifier = Modifier
                .size(120.dp)
                .background(color)
        )
    }
}