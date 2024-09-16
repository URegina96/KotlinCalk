package com.example.kotlincalc

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import net.objecthunter.exp4j.ExpressionBuilder

class CalculatorViewModel : ViewModel() {

    private var inputBuilder = StringBuilder()
    private val _display = MutableLiveData("0")
    val display: LiveData<String> get() = _display

    private val operators = listOf("+", "-", "*", "/")

    fun appendToInput(value: String) {
        inputBuilder.append(value)
        updateDisplay()
    }

    fun setOperator(op: String) {
        updateInputWithOperator(op)
        updateDisplay()
    }

    private fun updateInputWithOperator(op: String) {
        val lastChar = inputBuilder.toString().trim().lastOrNull()
        if (lastChar != null && !isOperator(lastChar.toString())) {
            inputBuilder.append(" $op ")
        } else if (lastChar != null && isOperator(lastChar.toString())) {
            inputBuilder.setLength(inputBuilder.length - 3)
            inputBuilder.append(" $op ")
        }
    }

    private fun isOperator(char: String): Boolean {
        return operators.contains(char)
    }

    fun calculateResult() {
        try {
            val expression = ExpressionBuilder(inputBuilder.toString()).build()
            val result = expression.evaluate()
            inputBuilder = StringBuilder(formatResult(result))
            updateDisplay()
        } catch (e: Exception) {
            _display.value = "Error"
        }
    }

    private fun formatResult(value: Double): String {
        return if (value % 1 == 0.0) {
            String.format("%.0f", value)
        } else {
            String.format("%.2f", value)
        }
    }

    fun clearInput() {
        inputBuilder.clear()
        _display.value = "0"
    }

    fun deleteLastCharacter() {
        if (inputBuilder.isNotEmpty()) {
            inputBuilder.setLength(inputBuilder.length - 1)
            updateDisplay()
        }
    }

    fun calculatePercent() {
        try {
            val expression = ExpressionBuilder(inputBuilder.toString()).build()
            val result = expression.evaluate() / 100
            inputBuilder = StringBuilder(formatResult(result))
            updateDisplay()
        } catch (e: Exception) {
            _display.value = "Error"
        }
    }

    fun calculateSqrt() {
        try {
            val expression = ExpressionBuilder(inputBuilder.toString()).build()
            val result = Math.sqrt(expression.evaluate())
            inputBuilder = StringBuilder(formatResult(result))
            updateDisplay()
        } catch (e: Exception) {
            _display.value = "Error"
        }
    }

    private fun updateDisplay() {
        _display.value = if (inputBuilder.isEmpty()) "0" else inputBuilder.toString()
    }
}
