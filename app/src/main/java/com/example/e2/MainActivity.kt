package com.example.e2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Math.pow
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val calcButton: Button = findViewById(R.id.buttonCalculate)
        val reset: Button = findViewById(R.id.buttonReset)


        calcButton.setOnClickListener { calculateBMI() }
        reset.setOnClickListener { reset() }
    }

    private fun calculateBMI() {
        val weight: Double = editTextWeight.text.toString().toDouble()
        var height: Double = editTextHeight.text.toString().toDouble()

        height /= 100
        val bmi: Double = weight / height.pow(2)
        textViewBMI.text = String.format("%.2f",bmi)

        setImage(bmi)
    }

    private fun setImage(bmi: Double) {
        when {
            bmi < 18.5 -> imageViewProfile.setImageResource(R.drawable.under)
            bmi > 18.5 && bmi < 24.9 -> imageViewProfile.setImageResource(R.drawable.normal)
            bmi > 25 -> imageViewProfile.setImageResource(R.drawable.over)
        }
    }

    private fun reset() {
        editTextWeight.text.clear()
        editTextHeight.text.clear()
        textViewBMI.text = ""
        imageViewProfile.setImageResource(R.drawable.empty)
    }


}




