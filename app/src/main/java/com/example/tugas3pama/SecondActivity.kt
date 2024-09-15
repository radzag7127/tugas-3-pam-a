package com.example.tugas3pama

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    private lateinit var resultTextView: TextView
    private lateinit var nimTextView: TextView
    private lateinit var nameTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        resultTextView = findViewById(R.id.resultTextView)
        nimTextView = findViewById(R.id.nimTextView)
        nameTextView = findViewById(R.id.nameTextView)

        val result = intent.getDoubleExtra("result", 0.0)
        val nim = intent.getStringExtra("nim") ?: "N/A"
        val name = intent.getStringExtra("nama") ?: "N/A"

        resultTextView.text = "Hasil: $result"
        nimTextView.text = "NIM: $nim"
        nameTextView.text = "Nama: $name"
    }
}
