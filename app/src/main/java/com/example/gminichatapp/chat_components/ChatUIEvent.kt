package com.example.gminichatapp.chat_components

import com.google.mediapipe.tasks.genai.llminference.LlmInference

sealed class ChatUiEvent {
    data class UpdatePrompt(val newPrompt: String) : ChatUiEvent()
    data class SendPrompt(
        val prompt: String,
        val generator: LlmInference
    ) : ChatUiEvent()
}