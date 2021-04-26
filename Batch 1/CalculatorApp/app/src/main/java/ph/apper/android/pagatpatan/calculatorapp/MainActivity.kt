package ph.apper.android.pagatpatan.calculatorapp

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var editText: TextView
    var number1: Float = 0f
    var isPlus: Boolean = false
    var isMinus: Boolean = false
    var isMultiply: Boolean = false
    var isDivide: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editText = findViewById(R.id.number_edit_text)
    }

    fun operationFunction(view: View) {
        when (view.id) {
            R.id.button_one -> {
                numberClicked(1)
            }
            R.id.button_two -> {
                numberClicked(2)
            }
            R.id.button_three -> {
                numberClicked(3)
            }
            R.id.button_four -> {
                numberClicked(4)
            }
            R.id.button_five -> {
                numberClicked(5)
            }
            R.id.button_six -> {
                numberClicked(6)
            }
            R.id.button_seven -> {
                numberClicked(7)
            }
            R.id.button_eight -> {
                numberClicked(8)
            }
            R.id.button_nine -> {
                numberClicked(9)
            }
            R.id.button_zero -> {
                numberClicked(0)
            }
            R.id.button_dot -> {
                dotClicked()
            }
            R.id.button_clear -> {
                editText.setText("")
            }
            R.id.button_plus -> {
                operationClicked()
                isPlus = true
            }
            R.id.button_minus -> {
                operationClicked()
                isMinus = true
            }
            R.id.button_multiply -> {
                operationClicked()
                isMultiply = true
            }
            R.id.button_divide -> {
                operationClicked()
                isDivide = true
            }
            R.id.button_equal -> {
                equalClicked()
            }
        }
    }

    private fun numberClicked(numberClicked: Int) {
        val number = editText.text.toString() + numberClicked.toString()
        editText.setText(number)
    }

    private fun dotClicked() {
        val number = editText.text.toString() + "."
        editText.setText(number)
    }

    private fun operationClicked() {
        number1 = editText.text.toString().toFloat()
        editText.setText("")
    }

    private fun equalClicked() {
        when {
            isPlus -> {
                plus()
            }
            isMinus -> {
                minus()
            }
            isMultiply -> {
                multiply()
            }
            isDivide -> {
                divide()
            }
        }
    }

    private fun plus() {
        val number2 = editText.text.toString().toFloat()
        val result = number1 + number2
        editText.setText(result.toString())
        isPlus = false
    }

    private fun minus() {
        val number2 = editText.text.toString().toFloat()
        val result = number1 - number2
        editText.setText(result.toString())
        isMinus = false
    }

    private fun multiply() {
        val number2 = editText.text.toString().toFloat()
        val result = number1 * number2
        editText.setText(result.toString())
        isMultiply = false
    }

    private fun divide() {
        val number2 = editText.text.toString().toFloat()
        val result = number1 / number2
        editText.setText(result.toString())
        isDivide = false
    }
}