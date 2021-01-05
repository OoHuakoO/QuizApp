package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val username = intent.getStringExtra(Constants.username)
        tv_name.text = username
        val correctAnswer = intent.getIntExtra(Constants.correct_answers,0)
        val totalQuestion = intent.getIntExtra(Constants.total_questions,0)

        tv_score.text = "Your Score is $correctAnswer out of $totalQuestion"
        btn_finish.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }
    }
}