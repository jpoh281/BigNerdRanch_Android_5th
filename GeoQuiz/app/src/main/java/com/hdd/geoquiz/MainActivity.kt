package com.hdd.geoquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.hdd.geoquiz.databinding.ActivityMainBinding

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val questionBank = listOf(
        Question(R.string.question_australia, true),
        Question(R.string.question_ocean, true),
        Question(R.string.question_mideast, true),
        Question(R.string.question_africa, true),
        Question(R.string.question_americas, true),
        Question(R.string.question_asia, true)
    )

    private var completedQuestions = mutableListOf<Question>()

    private var correctedQuestion = mutableListOf<Question>()

    private var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate(Bundle?) called")

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.trueButton.setOnClickListener { view: View ->
            checkAnswer(true)
        }

        binding.falseButton.setOnClickListener { view: View ->
            checkAnswer(false)
        }

        binding.nextButton.setOnClickListener {
            currentIndex = (currentIndex + 1) % questionBank.size
            updateQuestion()
        }

        updateQuestion()
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart() called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume() called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause() called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop() called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy() called")
    }

    private fun updateQuestion() {
        val questionTextResId = questionBank[currentIndex].textResId
        binding.questionTextView.setText(questionTextResId)
        changeActivated()
    }

    private fun checkAnswer(userAnswer: Boolean) {
        val correctAnswer = questionBank[currentIndex].answer
        completedQuestions.add(questionBank[currentIndex])

        val messageResId = if (userAnswer == correctAnswer) {
            correctedQuestion.add(questionBank[currentIndex])
            R.string.correct_text
        } else {
            R.string.incorrect_text
        }
        changeActivated()
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show()
        grade()
    }

    private fun changeActivated() {
        if (completedQuestions.contains(questionBank[currentIndex])) {
            binding.falseButton.isEnabled = false
            binding.trueButton.isEnabled = false
        } else {
            binding.falseButton.isEnabled = true
            binding.trueButton.isEnabled = true
        }
    }

    private fun grade() {
        if (completedQuestions.size == questionBank.size) {
            Toast.makeText(
                this,
                "${correctedQuestion.size} / ${questionBank.size}",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}