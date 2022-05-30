package com.example.composeexamplev3.ui.text

import android.content.res.Resources
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.composeexamplev3.R
import com.example.composeexamplev3.data.local.chat.SampleData
import com.example.composeexamplev3.domain.chat.Message
import com.example.composeexamplev3.ui.common.theme.ComposeExampleV3Theme
import androidx.compose.ui.unit.dp as dp1

class MessageActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeExampleV3Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    // MessageCard(message = Message("Android", "JetPack Compose"))
                    Conversation(messages = SampleData.conversationSample)
                }
            }
        }
    }
}


@Composable
fun MessageCard(message: Message) {
    Row(Modifier.padding(all = 8.dp1)) {
        Image(
            painter = painterResource(id = R.drawable.avatar),
            contentDescription = "Contact Profile Picture",
            Modifier
                .size(40.dp1)
                .clip(CircleShape)
                .border(1.5.dp1, MaterialTheme.colors.secondary, CircleShape)
        )
        //add horizontal space between image and texts
        Spacer(modifier = Modifier.width(8.dp1))
        // We keep track if the message is expanded or not in this
        // variable
        var isExpanded by remember { mutableStateOf(false) }
        //surface color will be animated form one color to another
        val surfaceColor: Color by animateColorAsState(targetValue =
         if(isExpanded) MaterialTheme.colors.primary else MaterialTheme.colors.secondary
        )

        Column(Modifier.clickable {
            isExpanded = !isExpanded
        }) {
            Text(
                text = message.auther,
                color = MaterialTheme.colors.secondaryVariant,
                style = MaterialTheme.typography.subtitle2
            )
            Spacer(modifier = Modifier.width(8.dp1))
            Surface(
                shape = MaterialTheme.shapes.medium,
                elevation = 1.dp1,
                //surface color will be changing gradually from primary to secondary
                color = surfaceColor,
                //animatecontent size will change the surface size gradually
                modifier = Modifier
                    .animateContentSize()
                    .padding(1.dp1),
            ) {
                Text(
                    text = message.body,
                    modifier = Modifier.padding(all = 4.dp1),
                    maxLines = if(isExpanded)Int.MAX_VALUE else 1,
                    style= MaterialTheme.typography.body2
                )
            }
        }
    }
}

@Composable
fun Conversation(messages: List<Message>) {
    LazyColumn {
        items(messages) { message ->
            MessageCard(message = message)
        }
    }
}

/*@Preview(name = "Light Mode")*/
/*@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)*/
@Preview
@Composable
fun previewConversation() {
    ComposeExampleV3Theme {
        Conversation(messages = SampleData.conversationSample)
    }
}
