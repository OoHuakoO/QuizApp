package com.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View

class QuizQuestionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)
        val questionList = Constants.getQuestions()
        Log.i("Question Size","${questionList.size}")
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        
    }
}