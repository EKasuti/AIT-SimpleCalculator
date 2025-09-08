package com.example.simplecalculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.simplecalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnShow.setOnClickListener {
            try {
                var numA = binding.etNumA.text.toString().toInt()
                var numB = binding.etNumB.text.toString().toInt()
                var sum = numA + numB

                binding.tvData.text = "Result: $sum"
            } catch (e: Exception) {
                binding.tvData.text = "Error: ${e.message}"
            }
        }
    }
}