package com.devdroid.onboarding.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.devdroid.onboarding.repository.QuestionRepository

class ViewModelFactory(private val context: Context): ViewModelProvider.Factory {

    override  fun <T: ViewModel> create(modelClass: Class<T>):T{
        if(modelClass.isAssignableFrom(ViewModel::class.java)){
            return ViewModel(QuestionRepository(context)) as T
        }
        throw IllegalArgumentException(" Unknown Class")
    }
}