package com.example.gminichatapp.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.gminichatapp.screens.ChatScreen
import com.google.mediapipe.tasks.genai.llminference.LlmInference
import com.nameisjayant.projects.chat.components.screens.StartScreen

@Composable
fun MainNavigation(generator: LlmInference) {

    val navHostController = rememberNavController()

    NavHost(navController = navHostController, startDestination = START_SCREEN) {
        composable(START_SCREEN) {
            StartScreen(navHostController)
        }

        composable(CHAT_SCREEN) {
            ChatScreen(navHostController, generator)
        }

    }

}

const val START_SCREEN = "Start screen"
const val CHAT_SCREEN = "Chat screen"