package com.example.kotlincalc

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.kotlincalc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: CalculatorViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(CalculatorViewModel::class.java)

        viewModel.display.observe(this) { result ->
            binding.resultTextView.text = result
        }

        setupButtons()
    }

    private fun setupButtons() {
        val numberButtons = arrayOf(
            binding.button0, binding.button1, binding.button2,
            binding.button3, binding.button4, binding.button5,
            binding.button6, binding.button7, binding.button8,
            binding.button9
        )

        numberButtons.forEachIndexed { index, button ->
            button.setOnClickListener { viewModel.appendToInput(index.toString()) }
        }

        binding.buttonPlus.setOnClickListener { viewModel.setOperator("+") }
        binding.buttonMinus.setOnClickListener { viewModel.setOperator("-") }
        binding.buttonMultiply.setOnClickListener { viewModel.setOperator("*") }
        binding.buttonDivide.setOnClickListener { viewModel.setOperator("/") }
        binding.buttonEqual.setOnClickListener { viewModel.calculateResult() }
        binding.buttonClear.setOnClickListener { viewModel.clearInput() }
        binding.buttonDot.setOnClickListener { viewModel.appendToInput(".") }
        binding.buttonBackspace.setOnClickListener { viewModel.deleteLastCharacter() }
        binding.buttonPercent.setOnClickListener { viewModel.calculatePercent() }
        binding.buttonSqrt.setOnClickListener { viewModel.calculateSqrt() }
    }
}
