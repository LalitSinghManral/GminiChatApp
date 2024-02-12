package com.example.gminichatapp.chat_components

import com.example.gminichatapp.data.Chat


data class ChatState (
    val chatList: MutableList<Chat> = mutableListOf(),
    val prompt: String = ""
)