package com.example.chatbot.data

data class ChatData(
    val message: String,
    val messageFrom: String
)

enum class MessageFromEnum(role: String){
    USER("user"),
    BOT("chat_bot")
}
