package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.autofill.OnClickAction
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import org.w3c.dom.Text

class quizActivity : AppCompatActivity(), View.OnClickListener{
    private var questionsList:ArrayList<Questions>?=null
    lateinit var q_Question:TextView
    lateinit var q_OptOne:TextView
    lateinit var q_OptTwo:TextView
    lateinit var q_OptThree:TextView
    lateinit var q_OptFour:TextView
    lateinit var q_Next:Button
    var currentpos:Int =1
    var selectedChoice:Int =0
    var q_OptOneId =1;
    var q_OptTwuId =2;
    var q_OptThreeId=3;
    var q_OptFourId=4;
    var marks:Int =0;
    var maxQuestions:Int =0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
        Log.i("--------->",selectedChoice.toString())
        Log.i("-------->",R.drawable.on_click_border.toString())
        var utility =Utility()
        questionsList=utility.getQuestion()

        var Name = findViewById<TextView>(R.id.q_name_)
        Name.text=intent.getStringExtra("name")

        q_Question=findViewById<TextView>(R.id.q_question)
        q_OptOne =findViewById<TextView>(R.id.q_optOne)
        q_OptTwo =findViewById<TextView>(R.id.q_optTwo)
        q_OptThree =findViewById<TextView>(R.id.q_optThree)
        q_OptFour =findViewById<TextView>(R.id.q_optFour)
        q_Next =findViewById<Button>(R.id.q_next)

        maxQuestions =questionsList!!.size


            setQuestion(currentpos)

            q_OptOne.setOnClickListener(this)
            q_OptTwo.setOnClickListener(this)
            q_OptThree.setOnClickListener(this)
            q_OptFour.setOnClickListener(this)

            q_Next.setOnClickListener(View.OnClickListener {
                var answer = questionsList!!.get(currentpos-1).answer
                Log.i("--------->",selectedChoice.toString())
                Log.i("--------->",answer.toString())
                checkAnswer(answer,selectedChoice);
                nextQuestion()
            })
    }

    private fun resAns(ans: Int,id: Int)
    {
        when(id)
        {
            1-> {
                if (ans == id) {
                    q_OptOne.background = ContextCompat.getDrawable(this, R.drawable.right_answer)
                    marks++;
                }
                else {
                    q_OptOne.background = ContextCompat.getDrawable(this, R.drawable.wrong_answer)
                }
            }

            2-> {
                if (ans == id) {
                    q_OptTwo.background = ContextCompat.getDrawable(this, R.drawable.right_answer)
                    marks++;
                }
                else {
                    q_OptTwo.background = ContextCompat.getDrawable(this, R.drawable.wrong_answer)

                }
            }
            3-> {
                if (ans == id) {
                    q_OptThree.background = ContextCompat.getDrawable(this, R.drawable.right_answer)
                    marks++;
                }
                else {
                    q_OptThree.background = ContextCompat.getDrawable(this, R.drawable.wrong_answer)
                }
            }
            4->{
                if (ans == id) {
                    q_OptFour.background = ContextCompat.getDrawable(this, R.drawable.right_answer)
                    marks++;
                }
                else {
                    q_OptFour.background = ContextCompat.getDrawable(this, R.drawable.wrong_answer)
                }
            }
        }
    }


   private fun checkAnswer(ans:Int,id:Int)
    {
        when(ans)
        {
            1 -> resAns(ans,id)
            2 -> resAns(ans,id)
            3 -> resAns(ans,id)
            4 -> resAns(ans,id)
        }
    }

    override fun onClick(v: View) {
        when(v.id)
        {
            R.id.q_optOne -> {
                selectedOption(q_OptOne,q_OptOneId)
            }
            R.id.q_optTwo -> {
                selectedOption(q_OptTwo,q_OptTwuId)
            }
            R.id.q_optThree -> {
                selectedOption(q_OptThree,q_OptThreeId)
            }
            R.id.q_optFour -> {
                selectedOption(q_OptFour,q_OptFourId)
            }
        }
    }


    private fun selectedOption(tv:TextView,num:Int)
    {
        defaultBackground();
        tv.background = ContextCompat.getDrawable(this,R.drawable.on_click_border)
        selectedChoice =num
    }

    private fun defaultBackground()
    {
        q_OptOne.background = ContextCompat.getDrawable(this,R.drawable.border_quiz)
        q_OptTwo.background =ContextCompat.getDrawable(this,R.drawable.border_quiz)
        q_OptThree.background=ContextCompat.getDrawable(this,R.drawable.border_quiz)
        q_OptFour.background = ContextCompat.getDrawable(this,R.drawable.border_quiz)
    }
    fun setQuestion(currentpos:Int){
        q_Question.text = questionsList!!.get(currentpos-1).question
        q_OptOne.text =questionsList!!.get(currentpos-1).optOne
        q_OptTwo.text =questionsList!!.get(currentpos-1).optTwo
        q_OptThree.text =questionsList!!.get(currentpos-1).optThree
        q_OptFour.text =questionsList!!.get(currentpos-1).optFour
    }


    fun nextQuestion()
    {

        if (questionsList!!.size>=currentpos)
        {
            q_Next.setOnClickListener(View.OnClickListener {

                q_Question=findViewById<TextView>(R.id.q_question)
                q_Question.text = questionsList!!.get(currentpos).question
                q_OptOne =findViewById<TextView>(R.id.q_optOne)
                q_OptOne.text =questionsList!!.get(currentpos).optOne
                q_OptTwo =findViewById<TextView>(R.id.q_optTwo)
                q_OptTwo.text =questionsList!!.get(currentpos).optTwo
                q_OptThree =findViewById<TextView>(R.id.q_optThree)
                q_OptThree.text =questionsList!!.get(currentpos).optThree
                q_OptFour =findViewById<TextView>(R.id.q_optFour)
                q_OptFour.text =questionsList!!.get(currentpos).optFour
            })

        }

    }
}














