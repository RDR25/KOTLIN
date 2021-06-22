package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.autofill.OnClickAction
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import org.w3c.dom.Text

class quizActivity : AppCompatActivity(), View.OnClickListener {
    private var questionsList: ArrayList<Questions>? = null
    lateinit var q_Question: TextView
    lateinit var q_Submit: Button
    var currentpos: Int = 1
    var selectedChoice: Int = 0
    var marks: Int = 0;
    var maxQuestions: Int = 0;
    lateinit var q_Endbtn:Button;
    lateinit var optionsList: List<TextView>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        var utility = Utility()
        questionsList = utility.getQuestion()

        var Name = findViewById<TextView>(R.id.q_name_)
        Name.text = intent.getStringExtra("name")

        q_Question = findViewById<TextView>(R.id.q_question)
        q_Submit = findViewById<Button>(R.id.q_submit)
        q_Endbtn = findViewById(R.id.q_end)

        val q_OptOne = findViewById<TextView>(R.id.q_optOne)
        val q_OptTwo = findViewById<TextView>(R.id.q_optTwo)
        val q_OptThree = findViewById<TextView>(R.id.q_optThree)
        val q_OptFour = findViewById<TextView>(R.id.q_optFour)
        var progressBar: ProgressBar = findViewById(R.id.q_pb)
        progressBar.max = questionsList!!.size
        progressBar.progress = currentpos

        optionsList = listOf(q_OptOne, q_OptTwo, q_OptThree, q_OptFour)

        //maxQuestions =questionsList!!.size

        setQuestion()

        for (option in optionsList) {
            option.setOnClickListener(this)
        }

        q_Submit.setOnClickListener(View.OnClickListener {
            var answer = questionsList!!.get(currentpos - 1).answer

            var btnText: String = q_Submit.text.toString()

            when (btnText) {
                "SUBMIT" -> {
                    checkAnswer(answer, selectedChoice);

                    for (option in optionsList) {
                        option.setClickable(false)
                    }
                    if (questionsList!!.size == currentpos) {
                        q_Submit.setText("FINISH")
                    } else {
                        q_Submit.setText("NEXT")
                    }
                }
                "NEXT" -> {
                    currentpos++
                    setQuestion()
                    for (option in optionsList) {
                        option.setClickable(true)
                    }
                    progressBar.progress = currentpos
                }
                "FINISH" -> {
                    Toast.makeText(this, "Your score is $marks", Toast.LENGTH_LONG).show()
                    var intent = Intent(this,QuizActivityRes()::class.java)
                    intent.putExtra("Name",Name.text.toString())
                    intent.putExtra("marks",marks.toString())
                    Log.i("-------->","$marks")
                    startActivity(intent)
                    finish()
                }
            }
        })

        q_Endbtn.setOnClickListener(View.OnClickListener {
            Toast.makeText(this, "Your score is $marks", Toast.LENGTH_LONG).show()
            var intent = Intent(this,QuizActivityRes()::class.java)
            intent.putExtra("Name",Name.text.toString())
            intent.putExtra("marks",marks.toString())
            Log.i("-------->","$marks")
            startActivity(intent)
            finish()
        })
    }

    private fun resAns(ans: Int, id: Int) {
        optionsList[id - 1].background = ContextCompat.getDrawable(this, R.drawable.wrong_answer)
        optionsList[ans - 1].background = ContextCompat.getDrawable(this, R.drawable.right_answer)
    }


    private fun checkAnswer(ans: Int, id: Int) {
        when (id) {
            1 -> resAns(ans, id)
            2 -> resAns(ans, id)
            3 -> resAns(ans, id)
            4 -> resAns(ans, id)
        }

        if (ans == id) {
            marks += 1
        }
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.q_optOne -> {
                selectedOption(optionsList[0], R.drawable.on_click_border)
                selectedChoice = 1
            }
            R.id.q_optTwo -> {
                selectedOption(optionsList[1], R.drawable.on_click_border)
                selectedChoice = 2
            }
            R.id.q_optThree -> {
                selectedOption(optionsList[2], R.drawable.on_click_border)
                selectedChoice = 3
            }
            R.id.q_optFour -> {
                selectedOption(optionsList[3], R.drawable.on_click_border)
                selectedChoice = 4
            }
        }
    }


    private fun selectedOption(tv: TextView, num: Int) {
        defaultBackground();
        tv.background = ContextCompat.getDrawable(this, num)

    }

    private fun defaultBackground() {
        optionsList[0].background = ContextCompat.getDrawable(this, R.drawable.border_quiz)
        optionsList[1].background = ContextCompat.getDrawable(this, R.drawable.border_quiz)
        optionsList[2].background = ContextCompat.getDrawable(this, R.drawable.border_quiz)
        optionsList[3].background = ContextCompat.getDrawable(this, R.drawable.border_quiz)
    }

    fun setQuestion() {
        q_Question.text = questionsList!!.get(currentpos - 1).question
        optionsList[0].text = questionsList!!.get(currentpos - 1).optOne
        optionsList[1].text = questionsList!!.get(currentpos - 1).optTwo
        optionsList[2].text = questionsList!!.get(currentpos - 1).optThree
        optionsList[3].text = questionsList!!.get(currentpos - 1).optFour
        defaultBackground();
        q_Submit.setText("SUBMIT")
    }

}














