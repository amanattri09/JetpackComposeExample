package com.example.composeexamplev3.ui.text

import android.graphics.Paint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeexamplev3.ui.text.ui.theme.ComposeExampleV3Theme

class TextStyleActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeExampleV3Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    val scrollState = rememberScrollState()
                    //smooth scroll to specified  pixels on first composition
                    /*LaunchedEffect(Unit){
                        scrollState.animateScrollTo(1000)
                    }*/
                    Column(Modifier.fillMaxSize().verticalScroll(scrollState)) {
                        // simple text
                        setTextStyling(displayText = "I am simple text")
                        // text with font size
                        setTextStyling(
                            displayText = "I am having font size  as 24 sp",
                            style = TextStyle(
                                fontSize = 24.sp
                            )
                        )
                        // text with font weight
                        setTextStyling(
                            displayText = "I am bold text",
                            style = TextStyle(
                                fontWeight = FontWeight.Bold
                            )
                        )
                        // text with font style
                        setTextStyling(
                            displayText = "I am italic text",
                            style = TextStyle(
                                fontStyle = FontStyle.Italic
                            )
                        )
                        // text with font size and style
                        setTextStyling(
                            displayText = "I am Italic text",
                            style = TextStyle(
                                fontStyle = FontStyle.Italic,
                                fontSize = 16.sp
                            )
                        )
                        // Text with color
                        setTextStyling(
                            displayText = "I am simple text having red color",
                            style = TextStyle(
                                color = Color.Red
                            )
                        )
                        // Text with font family
                        setTextStyling(
                            displayText = "My font family is Cursive",
                            style = TextStyle(
                                fontFamily = FontFamily.Cursive
                            )
                        )
                        // text with color , font weight , font style and font size
                        setTextStyling(
                            displayText = "I am text with more than one text style",
                            style = TextStyle(
                                color = Color.Red,
                                fontWeight = FontWeight.Bold,
                                fontStyle = FontStyle.Italic,
                                fontSize = 16.sp
                            )
                        )
                        /* text with decoration */
                        setTextStyling(
                            displayText = "I am an underlined text", TextStyle(
                                textDecoration = TextDecoration.Underline
                            )
                        )
                        setTextStyling(
                            displayText = "I am striking through text", TextStyle(
                                textDecoration = TextDecoration.LineThrough
                            )
                        )
                        // text with shadow
                        setTextStyling(
                            displayText = "I am having text shadow", style = TextStyle(
                                shadow = Shadow(
                                    color = Color.Red,
                                    blurRadius = 8f,
                                    offset = Offset(2f, 2f)
                                )
                            )
                        )
                        //text with background color =cyan
                        setTextStyling(
                            displayText = "I am a text having background color",
                            style = TextStyle(
                                background = Color.Cyan
                            )
                        )
                        // text with padding
                        setTextStyling(
                            displayText = "I am having 16dp padding in first line",
                            style = TextStyle(
                                textIndent = TextIndent(firstLine = 30.sp)
                            )
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun setTextStyling(displayText: String, style: TextStyle? = null, maxLines: Int? = null) {
    Text(
        text = displayText,
        modifier = Modifier.padding(16.dp),
        style = style ?: TextStyle.Default,
        overflow = TextOverflow.Ellipsis,
        maxLines = maxLines ?: Int.MAX_VALUE
    )
}


