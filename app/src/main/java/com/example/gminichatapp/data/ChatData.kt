package com.example.gminichatapp.data


import com.example.gminichatapp.model.generateTextResponse
import com.google.mediapipe.tasks.genai.llminference.LlmInference
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object ChatData {

    suspend fun getResponse(prompt: String,generator: LlmInference):Chat{

        try {
            val response = withContext(Dispatchers.Default) {
                generateTextResponse(prompt,generator)
            }

            return Chat(
                prompt = response,
                isFromUser = false
            )

        } catch (e: Exception) {
            return Chat(
                prompt = e.message ?: "error",
                isFromUser = false
            )
        }

    }

}