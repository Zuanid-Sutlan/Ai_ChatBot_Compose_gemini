package com.example.chatbot.data

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chatbot.api_key.Api
import com.google.ai.client.generativeai.GenerativeModel
import com.google.ai.client.generativeai.type.content
import kotlinx.coroutines.launch

class ChatBotViewModel: ViewModel() {

    private val apiKey = Api.API_KEY

    private val _chatList by lazy { mutableStateListOf<ChatData>() }
    val chatList = _chatList


    private val aiModel by lazy {
        GenerativeModel(
            modelName = "gemini-pro",
            apiKey = apiKey
        )
    }


    private val chat = aiModel.startChat()



    fun sendMessage(message: String){
//        if (_chatList.isNotEmpty()){
            _chatList.add(ChatData(message, MessageFromEnum.USER.name))
//        }
        viewModelScope.launch {
            try {
                chat.sendMessage(content { text(message) }).text?.let {
                    _chatList.add(ChatData(it, MessageFromEnum.BOT.name))
                    Log.i("sendMessage: ", it)
                }
            }catch (e:Exception){
                Log.i("sendMessage: ", e.message.toString())
            }
        }
    }

//    fun startChat(message: String){
//        viewModelScope.launch {
//            try {
//                chat.sendMessage(conten)
//            }
//        }
//    }

}