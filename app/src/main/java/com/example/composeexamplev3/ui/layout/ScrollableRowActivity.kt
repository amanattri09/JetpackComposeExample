package com.example.composeexamplev3.ui.layout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeexamplev3.domain.Blog
import com.example.composeexamplev3.domain.getBlogList
import com.example.composeexamplev3.ui.layout.ui.theme.ComposeExampleV3Theme

class ScrollableRowActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeExampleV3Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ScrollableRowColumn(bloglist = getBlogList())
                }
            }
        }
    }
}

@Composable
fun ScrollableRowColumn(bloglist: List<Blog>) {
    Column(Modifier.horizontalScroll(rememberScrollState())) {
        Row {
            bloglist.forEach {
                Card(shape = RoundedCornerShape(4.dp), modifier = Modifier.padding(16.dp), backgroundColor = Color.Red) {
                    Text(text = it.name, style = TextStyle.Default, modifier = Modifier.padding(16.dp))
                }
            }
        }
    }
}
