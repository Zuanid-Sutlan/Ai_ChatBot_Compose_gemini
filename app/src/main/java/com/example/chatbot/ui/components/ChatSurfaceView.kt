package com.example.chatbot.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.chatbot.data.ChatData
import com.example.chatbot.ui.theme.ChatBotTheme

@Composable
fun UserMessage(chatData: ChatData) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight(),
        ){

        Row(modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(8.dp),
            horizontalArrangement = Arrangement.Absolute.Right
        ) {
            Column(modifier = Modifier.padding(2.dp),
                horizontalAlignment = Alignment.End) {
                Row(horizontalArrangement = Arrangement.Absolute.Right) {
                    Text(text = "User")
                    Spacer(modifier = Modifier.width(8.dp))
                    Icon(imageVector = Icons.Default.Face, contentDescription = null)
                }
                Text(text = chatData.message, fontSize = 18.sp)

            }
        }
    }
}

@Composable
fun BotMessage(chatData: ChatData) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight(),
    ){

        Row(modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(8.dp),
            horizontalArrangement = Arrangement.Absolute.Left
        ) {
            Column(modifier = Modifier.padding(2.dp),
                horizontalAlignment = Alignment.Start) {
                Row(horizontalArrangement = Arrangement.Absolute.Left) {
                    Text(text = "Bot")
                    Spacer(modifier = Modifier.width(8.dp))
                    Icon(imageVector = Icons.Default.Face, contentDescription = null)
                }
                Text(text = chatData.message, fontSize = 18.sp)

            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Preview() {
    ChatBotTheme {
        Column {
            UserMessage(chatData = ChatData("Hi How are you", "us"))
            BotMessage(chatData = ChatData("Hi How are you", "us"))
        }
    }
}