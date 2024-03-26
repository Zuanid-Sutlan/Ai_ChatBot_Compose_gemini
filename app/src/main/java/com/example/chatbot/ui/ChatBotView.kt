package com.example.chatbot.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.chatbot.data.ChatBotViewModel
import com.example.chatbot.data.MessageFromEnum
import com.example.chatbot.ui.components.BotMessage
import com.example.chatbot.ui.components.BottomMessageView
import com.example.chatbot.ui.components.CustomTopAppBar
import com.example.chatbot.ui.components.UserMessage

@Composable
fun ChatBotView(viewModel: ChatBotViewModel) {

    val list = viewModel.chatList

//    viewModel.sendMessage("hi")

    Scaffold(
        topBar = { CustomTopAppBar() },
        bottomBar = {
            BottomMessageView(sendMessage = { query ->
                viewModel.sendMessage(query)
            })
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            items(list) { chatData ->
                if (chatData.messageFrom == MessageFromEnum.USER.name) {
                    UserMessage(chatData = chatData)
                } else {
                    BotMessage(chatData = chatData)
                }
            }
        }
    }


}