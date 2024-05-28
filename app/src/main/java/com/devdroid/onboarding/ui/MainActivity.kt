package com.devdroid.onboarding.ui

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.viewModels
import com.devdroid.onboarding.databinding.QuestionBinding
import com.devdroid.onboarding.viewmodel.MainViewModel
import com.devdroid.onboarding.viewmodel.ViewModelFactory
import java.io.Serializable

class MainActivity : AppCompatActivity() {

    private lateinit var binding: QuestionBinding
    private val viewModel: MainViewModel by viewModels {
        ViewModelFactory(applicationContext)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = QuestionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.currentIndex.observe(this) { index ->
            val questions = viewModel.questions.value ?: return@observe
            if (index < questions.size) {
                val question = questions[index]
                binding.questionText.text = question.question
                when (question.inputType) {
                    "text" -> binding.answerInput.inputType = InputType.TYPE_CLASS_TEXT
                    "number" -> binding.answerInput.inputType = InputType.TYPE_CLASS_NUMBER
                    "textEmailAddress" -> binding.answerInput.inputType = InputType.TYPE_CLASS_TEXT
                }
                binding.nextButton.text = if (index == questions.size - 1) "FINISH" else "NEXT"
            } else {
                showSummary()
            }
        }

        binding.nextButton.setOnClickListener {
            val answer = binding.answerInput.text.toString()
            viewModel.nextQuestion(answer)
            binding.answerInput.text.clear()
        }
    }

    private fun showSummary() {
        val answers = viewModel.answers.value ?: return
        val serializableAnswers = answers.entries.associate { it.key.question to it.value } as Serializable
        val intent = Intent(this, Summary::class.java).apply {
            putExtra("answers", serializableAnswers)
        }
        startActivity(intent)
    }
}
