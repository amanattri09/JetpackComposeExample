package com.example.composeexamplev3.ui.alert

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.composeexamplev3.ui.alert.ui.theme.ComposeExampleV3Theme

class AlertDialogActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeExampleV3Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    AlertDialogComponent()
                }
            }
        }
    }
}

@Composable
fun AlertDialogComponent() {
    val openDialog = remember {
        mutableStateOf(true)
    }
    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = { openDialog.value = false },
            title = {
                Text(text = "Alert Dialog")
            },
            text = {
                Text(text = "Hi i am alert dialog")
            },
            confirmButton = {
                TextButton(onClick = { openDialog.value = false }) {
                    Text(text = "Confirm")
                }
            },
            dismissButton = {
                TextButton(onClick = {
                    openDialog.value = false
                }) {
                    Text(text = "Dismiss")
                }
            },
            backgroundColor = Color.White,
            contentColor = Color.Black
        )
    }
}