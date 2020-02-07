//Kozyriev Dmytro
//WMAD Sr.B
//Android Asn 1 Rick & Morty Quiz
//2020-02-07
package com.android.example.rickandmortyquiz
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.android.example.rickandmortyquiz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //Creating binding object
    private lateinit var binding : ActivityMainBinding

    private var questionIndex = 0
    private lateinit var questionView: TextView
    private var answer : Boolean = false

    private val questionBank = listOf(
        Question(R.string.question_1, false),
        Question(R.string.question_2, true),
        Question(R.string.question_3, true),
        Question(R.string.question_4, false),
        Question(R.string.question_5, false),
        Question(R.string.question_6, true),
        Question(R.string.question_7, false),
        Question(R.string.question_8, true),
        Question(R.string.question_9, false),
        Question(R.string.question_10, false),
        Question(R.string.question_11, false),
        Question(R.string.question_12, true),
        Question(R.string.question_13, false),
        Question(R.string.question_14, true),
        Question(R.string.question_15, false),
        Question(R.string.question_16, false),
        Question(R.string.question_17, true),
        Question(R.string.question_18, false),
        Question(R.string.question_19, false),
        Question(R.string.question_20, true))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    //Adding a reference to the binding object to the main activity, so view can be accessed:
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        questionView = findViewById(R.id.question_view)
        questionView.setText(questionBank[questionIndex].index)


            binding.previousButton.setOnClickListener{
                this@MainActivity.previousQuestion()
            }
            binding.nextButton.setOnClickListener{
                this@MainActivity.nextQuestion()
            }
            binding.trueButton.setOnClickListener{
                answer = true
                this@MainActivity.checkAnswer()
            }
            binding.falseButton.setOnClickListener{
                answer = false
                this@MainActivity.checkAnswer()
            }

    }


    private fun nextQuestion(){
        questionIndex = (questionIndex + 1) % 20
        questionView.setText(questionBank[questionIndex].index)
    }


    private fun previousQuestion(){
        questionIndex = (questionIndex + 19) % 20
        questionView.setText(questionBank[questionIndex].index)
    }


    private fun checkAnswer(){
        if(questionBank[questionIndex].answer == answer){
            Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show()
        }
        else{
            Toast.makeText(getApplicationContext(), "You are wrong, try again", Toast.LENGTH_SHORT).show()
        }
    }
}
