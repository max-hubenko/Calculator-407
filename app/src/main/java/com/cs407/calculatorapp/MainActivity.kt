package com.cs407.calculatorapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val editNumOne = findViewById<EditText>(R.id.numOneInput)
        val editNumTwo = findViewById<EditText>(R.id.numTwoInput)

        val addButton = findViewById<Button>(R.id.addButton)
        val subtractButton = findViewById<Button>(R.id.subtractButton)
        val multiplyButton = findViewById<Button>(R.id.multiplyButton)
        val divideButton = findViewById<Button>(R.id.divideButton)

        val intent = Intent(this, ResultActivity::class.java)

        addButton.setOnClickListener {
            val numOne = editNumOne.text.toString().toFloatOrNull()
            val numTwo = editNumTwo.text.toString().toFloatOrNull()

            if (numOne == null || numTwo == null) {
                Toast.makeText(this, "Please enter valid numbers", Toast.LENGTH_SHORT).show()
            } else {
                intent.putExtra("Extra Message", (numOne + numTwo).toString())
                startActivity(intent)
            }
        }

        subtractButton.setOnClickListener {
            val numOne = editNumOne.text.toString().toFloatOrNull()
            val numTwo = editNumTwo.text.toString().toFloatOrNull()

            if (numOne == null || numTwo == null) {
                Toast.makeText(this, "Please enter integers", Toast.LENGTH_SHORT).show()
            } else {
                intent.putExtra("Extra Message", (numOne - numTwo).toString())
                startActivity(intent)
            }
        }

        multiplyButton.setOnClickListener {
            val numOne = editNumOne.text.toString().toFloatOrNull()
            val numTwo = editNumTwo.text.toString().toFloatOrNull()

            if (numOne == null || numTwo == null) {
                Toast.makeText(this, "Please enter integers", Toast.LENGTH_SHORT).show()
            } else {
                intent.putExtra("Extra Message", (numOne * numTwo).toString())
                startActivity(intent)
            }
        }

        divideButton.setOnClickListener {
            val numOne = editNumOne.text.toString().toFloatOrNull()
            val numTwo = editNumTwo.text.toString().toFloatOrNull()

            if (numOne == null || numTwo == null) {
                Toast.makeText(this, "Please enter integers", Toast.LENGTH_SHORT).show()
            } else if (numTwo == 0.toFloat()) {
                Toast.makeText(this, "Division by zero is not allowed", Toast.LENGTH_SHORT).show()
            } else {
                intent.putExtra("Extra Message", (numOne / numTwo).toString())
                startActivity(intent)
            }
        }
    }
}
