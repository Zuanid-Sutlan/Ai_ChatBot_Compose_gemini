package com.example.chatbot.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun BottomMessageView(sendMessage: (String) -> Unit) {

    var userInput by remember { mutableStateOf("") }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp),
            singleLine = true,
            value = userInput,
            onValueChange = { userInput = it },
            trailingIcon = {
                IconButton(onClick = {
                    sendMessage(userInput)
                    userInput = ""
                }) {
                    Icon(imageVector = Icons.Rounded.Send, contentDescription = null)
                }
            },
            placeholder = { Text(text = "Say something ...") })
        /*IconButton(onClick = { sendMessage(userInput) }, modifier = Modifier.size(24.dp)) {
            Icon(imageVector = Icons.Rounded.Send, contentDescription = null)
            Spacer(modifier = Modifier.width(10.dp))
        }*/
    }
}