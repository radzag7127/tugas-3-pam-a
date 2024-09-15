package com.example.tugas3pama

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var display: EditText
    private var currentOperation: String? = null
    private var operand1: Double? = null
    private var operand2: Double? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        display = findViewById(R.id.display)

        val button0 = findViewById<Button>(R.id.button0)
        val button1 = findViewById<Button>(R.id.button1)
        val button2 = findViewById<Button>(R.id.button2)
        val button3 = findViewById<Button>(R.id.button3)
        val button4 = findViewById<Button>(R.id.button4)
        val button5 = findViewById<Button>(R.id.button5)
        val button6 = findViewById<Button>(R.id.button6)
        val button7 = findViewById<Button>(R.id.button7)
        val button8 = findViewById<Button>(R.id.button8)
        val button9 = findViewById<Button>(R.id.button9)

        val buttonAdd = findViewById<Button>(R.id.buttonAdd)
        val buttonSubtract = findViewById<Button>(R.id.buttonSubtract)
        val buttonMultiply = findViewById<Button>(R.id.buttonMultiply)
        val buttonDivide = findViewById<Button>(R.id.buttonDivide)
        val buttonEqual = findViewById<Button>(R.id.buttonEqual)
        val buttonClear = findViewById<Button>(R.id.buttonClear)

        val numberButtons = listOf(button0, button1, button2, button3, button4, button5, button6, button7, button8, button9)
        numberButtons.forEach { button ->
            button.setOnClickListener {
                display.append(button.text)
            }
        }

        buttonAdd.setOnClickListener { setOperation("+") }
        buttonSubtract.setOnClickListener { setOperation("-") }
        buttonMultiply.setOnClickListener { setOperation("*") }
        buttonDivide.setOnClickListener { setOperation("/") }

        buttonEqual.setOnClickListener {
            operand2 = display.text.toString().toDoubleOrNull()
            val result = calculateResult()
            result?.let {
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("result", it)
                intent.putExtra("nim", "225150400111022")
                intent.putExtra("nama", "Radyza Glagah Sudharma")
                startActivity(intent)
                reset()
            }
        }

        buttonClear.setOnClickListener {
            display.text.clear()
            reset()
        }
    }

    private fun setOperation(operation: String) {
        operand1 = display.text.toString().toDoubleOrNull()
        currentOperation = operation
        display.text.clear()
    }

    private fun calculateResult(): Double? {
        return when (currentOperation) {
            "+" -> operand1?.plus(operand2 ?: 0.0)
            "-" -> operand1?.minus(operand2 ?: 0.0)
            "*" -> operand1?.times(operand2 ?: 1.0)
            "/" -> if (operand2 != 0.0) operand1?.div(operand2 ?: 1.0) else null
            else -> null
        }
    }

    private fun reset() {
        operand1 = null
        operand2 = null
        currentOperation = null
    }
}
