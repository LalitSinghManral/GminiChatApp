package com.example.gminichatapp.model

import android.content.Context
import android.util.Log
import com.google.mediapipe.tasks.core.Delegate
import com.google.mediapipe.tasks.genai.llminference.LlmInference
import java.io.File

const val MODEL_PATH = "/data/local/tmp/g_mini_2b/phi2_gpu.tflite"

fun initModel(context: Context):LlmInference?{

    if(validateModelFound()) {
        Log.i("LLM G_mini Chat App", "Validate True")
        val options = LlmInference.LlmInferenceOptions.builder()
            .setModelPath(MODEL_PATH)
            .setDelegate(Delegate.GPU)
            .setNumDecodeStepsPerSync(3)
            .setTopK(1)
            .setRandomSeed(0)
            .setTemperature(0f)

        Log.i("LLM G_mini Chat App", "Options intialised")
        val textGenerator = LlmInference.createFromOptions(context, options.build())

        return textGenerator

    }
    return null
}

fun generateTextResponse(prompt: String, generator: LlmInference): String{
    val textGenerator = generator
    val result = textGenerator.generateResponse(prompt)
    return  result

}

fun validateModelFound(): Boolean{
    if (!File(MODEL_PATH).exists()) {
        Log.e("LLM G_mini Chat App","No Model Found")
        return false;
    }else{
        Log.i("LLM G_mini Chat App","Model Found")
        return true
    }
}