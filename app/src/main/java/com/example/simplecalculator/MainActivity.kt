package com.example.simplecalculator

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.simplecalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAdd.setOnClickListener {
            calculate { a, b -> a + b }
        }

        binding.btnSubtract.setOnClickListener {
            calculate { a, b -> a - b }
        }

        binding.btnMultiply.setOnClickListener {
            calculate { a, b -> a * b }
        }

        binding.btnDivide.setOnClickListener {
            calculate { a, b -> a / b }
        }
    }

    private fun calculate(operation: (Double, Double) -> Double) {
        val numA = binding.etNumA.text.toString()
        val numB = binding.etNumB.text.toString()

        if (numA.isEmpty() || numB.isEmpty()) {
            Toast.makeText(this, "Please enter both numbers", Toast.LENGTH_SHORT).show()
            return
        }

        try {
            val a = numA.toDouble()
            val b = numB.toDouble()
            val result = operation(a, b)
            binding.tvData.text = "Result: $result"
        } catch (e: Exception) {
            Toast.makeText(this, "Please enter valid numbers", Toast.LENGTH_SHORT).show()
        }
    }
}