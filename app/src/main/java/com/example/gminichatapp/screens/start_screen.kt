package com.nameisjayant.projects.chat.components.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.gminichatapp.R
import com.example.gminichatapp.app_components.ButtonComponent
import com.example.gminichatapp.navigation.CHAT_SCREEN
import com.example.gminichatapp.ui.theme.TensorFlow_Orange_color


@Composable
fun StartScreen(
    navHostController: NavHostController
) {
    var nameValue by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
                .padding(8.dp),
            verticalArrangement = Arrangement.SpaceBetween) {
            Image(
                painter = painterResource(R.drawable.bannerimage), contentDescription = "",
                contentScale = ContentScale.Fit,
                alignment = Alignment.Center
            )
            Image(
                painter = painterResource(R.drawable.bannerimage2), contentDescription = "",
                contentScale = ContentScale.Fit,
                modifier = Modifier.fillMaxWidth(),
                alignment = Alignment.Center
            )
        }


        Box(
            modifier = Modifier
                .padding(top = 200.dp)
                .background(Color.Black)
                .align(Alignment.Center)

        ) {
            Column(
                modifier = Modifier
                    .padding(horizontal = 20.dp, vertical = 40.dp)
            ) {
                Text(
                    text = stringResource(R.string.stay_with_your_chatbot),
                    style = TextStyle(
                        fontSize = 36.sp,
                        color = TensorFlow_Orange_color,
                        fontWeight = FontWeight.Bold
                    )
                )
                Text(
                    text = stringResource(R.string.model_description), style = TextStyle(
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier.padding(10.dp)
                )

                Text(
                    text = stringResource(R.string.enter_your_name), style = TextStyle(
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier.padding(top=30.dp, bottom = 20.dp)
                )


                TextField(value = nameValue,
                    onValueChange = {nameValue = it},
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier
                        .padding(bottom = 32.dp)
                        .fillMaxWidth()
                )


            }
        }

        ButtonComponent(
            modifier = Modifier
                .padding(20.dp)
                .align(Alignment.BottomCenter)
                .height(60.dp),
            colors = ButtonDefaults.buttonColors(TensorFlow_Orange_color)
        ) {
            navHostController.currentBackStackEntry?.savedStateHandle?.set(
                "data", nameValue)
            navHostController.navigate(CHAT_SCREEN)
            Log.i("Start Screen","text Field Value "+nameValue)
        }
    }
}
