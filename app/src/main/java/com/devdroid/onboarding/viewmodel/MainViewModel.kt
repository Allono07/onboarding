package com.devdroid.onboarding.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.devdroid.onboarding.model.Question
import com.devdroid.onboarding.repository.QuestionRepository

class MainViewModel(private val repository: QuestionRepository) : ViewModel() {
    private val _questions = MutableLiveData<List<Question>>()
    val questions: LiveData<List<Question>> get() = _questions

    private val _currentIndex = MutableLiveData<Int>()
    val currentIndex: LiveData<Int> get() = _currentIndex

    private val _answers = MutableLiveData<MutableMap<Question, String>>()
    val answers: LiveData<MutableMap<Question, String>> get() = _answers

    init {
        _questions.value = repository.loadQuestion()
        _currentIndex.value = 0
        _answers.value = mutableMapOf()
    }

    fun nextQuestion(answer: String) {
        val currentQuestion = _questions.value?.get(_currentIndex.value!!) ?: return
        _answers.value?.put(currentQuestion, answer)
        _currentIndex.value = _currentIndex.value?.plus(1)
    }
}
