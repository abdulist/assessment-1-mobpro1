package org.d3if4504.simplecalculator

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import net.objecthunter.exp4j.ExpressionBuilder
import org.d3if4504.simplecalculator.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button0.setOnClickListener { binding.inputTextView.append("0") }
        binding.button1.setOnClickListener { binding.inputTextView.append("1") }
        binding.button2.setOnClickListener { binding.inputTextView.append("2") }
        binding.button3.setOnClickListener { binding.inputTextView.append("3") }
        binding.button4.setOnClickListener { binding.inputTextView.append("4") }
        binding.button5.setOnClickListener { binding.inputTextView.append("5") }
        binding.button6.setOnClickListener { binding.inputTextView.append("6") }
        binding.button7.setOnClickListener { binding.inputTextView.append("7") }
        binding.button8.setOnClickListener { binding.inputTextView.append("8") }
        binding.button9.setOnClickListener { binding.inputTextView.append("9") }

        binding.buttonAdd.setOnClickListener {
            if (binding.inputTextView.text.isEmpty()) {
                val toast1 = Toast.makeText(this, "Masukkan Angka!", Toast.LENGTH_SHORT)
                toast1.show()
            } else {
                binding.inputTextView.append("+")
            }
        }

        binding.buttonSubtract.setOnClickListener {
            if (binding.inputTextView.text.isEmpty()) {
                val toast1 = Toast.makeText(this, "Masukkan Angka!", Toast.LENGTH_SHORT)
                toast1.show()
            } else {
                binding.inputTextView.append("-")
            }
        }

        binding.buttonMultiply.setOnClickListener {
            if (binding.inputTextView.text.isEmpty()) {
                val toast1 = Toast.makeText(this, "Masukkan Angka!", Toast.LENGTH_SHORT)
                toast1.show()
            } else {
                binding.inputTextView.append("*")
            }
        }

        binding.buttonDivide.setOnClickListener {
            if (binding.inputTextView.text.isEmpty()) {
                val toast1 = Toast.makeText(this, "Masukkan Angka!", Toast.LENGTH_SHORT)
                toast1.show()
            } else {
                binding.inputTextView.append("*")
            }
        }

        binding.buttonClear.setOnClickListener { clearCalc() }

        binding.buttonEquals.setOnClickListener {
            if (binding.inputTextView.text.isEmpty()) {
                val toast1 = Toast.makeText(this, "Masukkan Angka!", Toast.LENGTH_SHORT)
                toast1.show()
            } else {
                calculate()
            }
        }
    }
    private fun calculate() {
        val expression = binding.inputTextView.text.toString()
        val result = ExpressionBuilder(expression).build().evaluate()
        binding.resultTextView.text = result.toString()
    }

    private fun clearCalc(){
        binding.inputTextView.text=""
        binding.resultTextView.text=""
    }
}