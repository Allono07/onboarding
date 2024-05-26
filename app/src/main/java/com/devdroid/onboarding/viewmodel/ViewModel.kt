package com.devdroid.onboarding.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.devdroid.onboarding.model.Question
import com.devdroid.onboarding.repository.QuestionRepository

class ViewModel(private val repository: QuestionRepository) : ViewModel() {
    private val _questions  = MutableLiveData<List<Question>>()

    val questions : LiveData<List<Question>> get() = _questions

    private val _currentIndex = MutableLiveData<Int>()
    val currentIndex: LiveData<Int> get() =_currentIndex

    private val _answers = MutableLiveData<MutableMap<Question,String>>()


}