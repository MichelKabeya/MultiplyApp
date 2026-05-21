package com.example.multiplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
      // created a function that will perform calculation
    private fun multiply(){
        //declared the variable that will hold the final result
        val numProduct: Int = value1 * value2
        answer.text = numProduct.toString()
    }
    var num1 = findViewById<EditText>(R.id.editText1)
    var num2 = findViewById<EditText>(R.id.editText2)
    var value1 = num1.text.toString().toInt()
    var value2 = num2.text.toString().toInt()
    var answer = findViewById<TextView>(R.id.textAns)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val calBtn = findViewById<Button>(R.id.multiplyBtn)

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