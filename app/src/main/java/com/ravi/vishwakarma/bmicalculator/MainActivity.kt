package com.ravi.vishwakarma.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ravi.vishwakarma.bmicalculator.databinding.ActivityMainBinding
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculateBtn.setOnClickListener {
            calculateBMI()
        }

    }

    private fun calculateBMI(){
        val weight = binding.weightEdit.text.toString().toFloatOrNull()
        val height = binding.heightEdit.text.toString().toFloatOrNull()

        if(weight != null && height != null){
            val bmi = weight/(height/100).pow(2)
            val bmiResult = String.format("%.2f", bmi)

            val bmiCategory = when {
                bmi < 18.5 -> getString(R.string.underweight)
                bmi < 25 -> getString(R.string.normal_weight)
                bmi < 30 -> getString(R.string.overweight)
                else -> getString(R.string.obese)
            }
            binding.resultText.text = "BMI: $bmiResult\nCategogy: $bmiCategory"
        } else {
            binding.resultText.text = getString(R.string.invalid_input)
        }
    }
}