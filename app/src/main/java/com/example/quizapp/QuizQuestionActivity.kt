package com.example.quizapp

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_quiz_question.*
import java.util.*
import kotlin.collections.ArrayList

class QuizQuestionActivity : AppCompatActivity(),View.OnClickListener {

    private var mCurrentPosition:Int = 1
    private var mQuestionsList:ArrayList<Question>? = null
    private var mSelectionOptionPosition : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)
        mQuestionsList = Constants.getQuestions()
        setQuestion()
        tv_option_one.setOnClickListener(this)
        tv_option_two.setOnClickListener(this)
        tv_option_three.setOnClickListener(this)
        tv_option_four.setOnClickListener(this)
        btn_submit.setOnClickListener(this)
    }
    //เป็นฟังก์ชัน set ชุดคำถามใหม่หลังจากกด next question
    private fun setQuestion(){

        val question =  mQuestionsList!![mCurrentPosition-1]
        defaultOptionsView()
        if(mCurrentPosition == mQuestionsList!!.size){
            btn_submit.text = "Finish"
        }else{
            btn_submit.text="Submit"
        }

        progressBar.progress = mCurrentPosition
        tv_progress.text = "$mCurrentPosition" + "/" + progressBar.max
        tv_question.text = question!!.question
        iv_image.setImageResource(question.image)
        tv_option_one.text = question.optionOne
        tv_option_two.text = question.optionTwo
        tv_option_three.text = question.optionThree
        tv_option_four.text = question.optionFour
    }
    //เป็นฟังก์ชันตั้งสีมาตรฐานของปุ่ม option
    private fun defaultOptionsView(){
        val Options = ArrayList<TextView>()
        Options.add(0,tv_option_one)
        Options.add(1,tv_option_two)
        Options.add(2,tv_option_three)
        Options.add(3,tv_option_four)
        for(option in Options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.defaults_option_border_bg
            )
        }
    }
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.tv_option_one -> {
                selectOptionView(tv_option_one, 1)
            }
            R.id.tv_option_two -> {
                selectOptionView(tv_option_two, 2)
            }
            R.id.tv_option_three -> {
                selectOptionView(tv_option_three, 3)
            }
            R.id.tv_option_four -> {
                selectOptionView(tv_option_four, 4)
            }
            R.id.btn_submit -> {
                if (mSelectionOptionPosition == 0) {
                    mCurrentPosition++
                    if (mCurrentPosition <= mQuestionsList!!.size) {
                        setQuestion()
                    } else {
                        Toast.makeText(
                            this,
                            "You have successfully completed the quiz",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                } else {
                    val question = mQuestionsList?.get(mCurrentPosition - 1)
                    if (question!!.correctAnswer != mSelectionOptionPosition) {
                        answerView(mSelectionOptionPosition, R.drawable.wrong_option_border_bg)
                    }
                    answerView(question.correctAnswer, R.drawable.correct_option_border_bg)
                    if (mCurrentPosition == mQuestionsList!!.size) {
                        btn_submit.text = "Finish"
                    } else {
                        btn_submit.text = "Go to next question"
                    }
                    mSelectionOptionPosition = 0
                }
            }
        }
    }
    //เป็นฟังก์ชันโชว์คำตอบ
    private fun answerView(answer:Int,drawbleView:Int){
        when(answer){
            1 ->{
                tv_option_one.background  = ContextCompat.getDrawable(this,drawbleView)
            }
            2 ->{
                tv_option_two.background  = ContextCompat.getDrawable(this,drawbleView)
            }
            3 ->{
                tv_option_three.background  = ContextCompat.getDrawable(this,drawbleView)
            }
            4 ->{
                tv_option_four.background  = ContextCompat.getDrawable(this,drawbleView)
            }
        }
    }
    //เป็นฟังก์ชันเลือก option แล้วเปลี่ยนสีกรอบเป็นสีม่วงและตัวอักษรสีดำเข้ม
    private fun selectOptionView(tv:TextView,selectedOptionNum:Int ){
        defaultOptionsView()
        mSelectionOptionPosition = selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_bg
        )
    }
}