package com.example.composeexamplev3.ui.text

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeexamplev3.ui.text.ui.theme.ComposeExampleV3Theme

class TextFieldActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeExampleV3Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(Modifier.verticalScroll(rememberScrollState())) {
                        SimpleTextComponent(text = "Example of simple text field")
                        simpleTextFieldComponent()
                        //divider
                        Divider(color = Color.LightGray)
                    }
                }
            }
        }
    }
}

@Composable
fun SimpleTextComponent(text: String) {
    Text(
        text = text, style = TextStyle(fontSize = 16.sp, color = Color.Black), modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    )
}

@Composable
fun simpleTextFieldComponent() {
        var text by remember {
            mutableStateOf(TextFieldValue("Enter text here"))
        }
        TextField(
            value = text, onValueChange = {
                text = it
            }, modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        )
}