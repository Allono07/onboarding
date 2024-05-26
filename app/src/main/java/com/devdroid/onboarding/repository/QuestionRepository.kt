package com.devdroid.onboarding.repository

import android.content.Context
import com.devdroid.onboarding.model.Question
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException

class QuestionRepository(private val context: Context) {

    fun loadQuestion(): List<Question>{
        val jsonString: String
        try{
            jsonString = context.assets.open("assets.json").bufferedReader().use { it.readText()}
        } catch (ioException: IOException){
            ioException.printStackTrace()
            return emptyList()
        }
        val listType = object : TypeToken<List<Question>>() {}.type
        return Gson().fromJson(jsonString, listType)

    }
}