package com.example.multiplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
      private lateinit var num1: EditText
    private lateinit var num2: EditText
    private lateinit var answer: TextView

    // created a function that will perform calculation
    private fun multiply() {
        val value1 = num1.text.toString().toInt()
        val value2 = num2.text.toString().toInt()

        val numProduct = value1 * value2
        answer.text = numProduct.toString()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // findViewById can only be used after setContentView
        //into onCreate() method
        num1 = findViewById(R.id.editText1)
        num2 = findViewById(R.id.editText2)
        answer = findViewById(R.id.textAns)

        val calBtn = findViewById<Button>(R.id.multiplyBtn)

        // the multiply function will be called when the button is clicked
        calBtn.setOnClickListener {
            multiply()
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}