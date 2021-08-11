package com.kkapps.calculator

import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageButton
import android.widget.TextView
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private var button0: Button? = null
    private var button1: Button? = null
    private var button2: Button? = null
    private var button3: Button? = null
    private var button4: Button? = null
    private var button5: Button? = null
    private var button6: Button? = null
    private var button7: Button? = null
    private var button8: Button? = null
    private var button9: Button? = null
    private var buttonDot: Button? = null
    private var buttonPlusMinus: Button? = null
    private var buttonAdd: Button? = null
    private var buttonSubtract: Button? = null
    private var buttonMultiply: Button? = null
    private var buttonDivide: Button? = null
    private var buttonPercent: Button? = null
    private var buttonEqual: Button? = null
    private var buttonBack: ImageButton? = null
    private var buttonClear: Button? = null
    private var textView1: TextView? = null
    private var textView2: TextView? = null
    private var textView3: TextView? = null
    private val numberRegex: Regex = "(.*)[0-9](.*)".toRegex()

    // Function for Calculation
    private fun calculationAnswerFunction() : String? {
        if (textView1!!.text.matches(numberRegex) && textView2!!.text != "" && textView3!!.text.matches(numberRegex)) {
            return when (textView2!!.text) {
                "/" -> (textView3!!.text.toString().toDouble() / textView1!!.text.toString().toDouble()).toString()
                "x" -> (textView3!!.text.toString().toDouble() * textView1!!.text.toString().toDouble()).toString()
                "+" -> (textView3!!.text.toString().toDouble() + textView1!!.text.toString().toDouble()).toString()
                "-" -> (textView3!!.text.toString().toDouble() - textView1!!.text.toString().toDouble()).toString()
                "%" -> ((textView3!!.text.toString().toDouble() * textView1!!.text.toString()
                    .toDouble()) / 100).toString()
                else -> ""
            }
        }
        return null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button0 = findViewById(R.id.button0)
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        button5 = findViewById(R.id.button5)
        button6 = findViewById(R.id.button6)
        button7 = findViewById(R.id.button7)
        button8 = findViewById(R.id.button8)
        button9 = findViewById(R.id.button9)
        buttonDot = findViewById(R.id.buttonDot)
        buttonPlusMinus = findViewById(R.id.buttonPlusMinus)
        buttonAdd = findViewById(R.id.buttonAdd)
        buttonSubtract = findViewById(R.id.buttonSubtract)
        buttonMultiply = findViewById(R.id.buttonMultiply)
        buttonDivide = findViewById(R.id.buttonDivide)
        buttonPercent = findViewById(R.id.buttonPercent)
        buttonEqual = findViewById(R.id.buttonEqual)
        buttonBack = findViewById(R.id.buttonBack)
        buttonClear = findViewById(R.id.buttonClear)
        textView1 = findViewById(R.id.textView1)
        textView2 = findViewById(R.id.textView2)
        textView3 = findViewById(R.id.textView3)

        buttonBack!!.setOnClickListener { textView1!!.text = textView1!!.text.dropLast(1) }

        buttonClear!!.setOnClickListener {
            textView1!!.text = ""
            textView2!!.text = ""
            textView3!!.text = ""
        }

        buttonEqual!!.setOnClickListener {
            if (calculationAnswerFunction() != null) {
                textView3!!.text = calculationAnswerFunction()
                textView1!!.text = ""
                textView2!!.text = ""
            }
        }
    }

    // Function for Button Pressed
   fun buttonPressed(view: View) {
        if (button0!!.isPressed) textView1!!.append(button0!!.text)
        if (button1!!.isPressed) textView1!!.append(button1!!.text)
        if (button2!!.isPressed) textView1!!.append(button2!!.text)
        if (button3!!.isPressed) textView1!!.append(button3!!.text)
        if (button4!!.isPressed) textView1!!.append(button4!!.text)
        if (button5!!.isPressed) textView1!!.append(button5!!.text)
        if (button6!!.isPressed) textView1!!.append(button6!!.text)
        if (button7!!.isPressed) textView1!!.append(button7!!.text)
        if (button8!!.isPressed) textView1!!.append(button8!!.text)
        if (button9!!.isPressed) textView1!!.append(button9!!.text)
        if (buttonDot!!.isPressed && !textView1!!.text.contains(".")) textView1!!.append(buttonDot!!.text)

        if (buttonPlusMinus!!.isPressed) {
            if (textView1!!.text.contains("-")) {
                val value = textView1!!.text.toString().replace("-", "")
                textView1!!.text = value
            } else {
                val value = "-${textView1!!.text}"
                textView1!!.text = value
            }
        }
        if (buttonPercent!!.isPressed){
            if (textView1!!.text.matches(numberRegex)) {
                if (textView3!!.text != ""){
                    textView3!!.text = calculationAnswerFunction()
                } else
                    textView3!!.text = textView1!!.text
            }
            textView2!!.text = "%"
            textView1!!.text = ""
        }
        if (buttonDivide!!.isPressed){
            if (textView1!!.text.matches(numberRegex)) {
                if (textView3!!.text != "") {
                    textView3!!.text = calculationAnswerFunction()
                } else
                    textView3!!.text = textView1!!.text
            }
            textView2!!.text = "/"
            textView1!!.text = ""
        }
        if (buttonMultiply!!.isPressed) {
            if (textView1!!.text.matches(numberRegex)) {
                if (textView3!!.text != "") {
                    textView3!!.text = calculationAnswerFunction()
                } else
                    textView3!!.text = textView1!!.text
            }
            textView2!!.text = "x"
            textView1!!.text = ""
        }
        if (buttonAdd!!.isPressed){
            if (textView1!!.text.matches(numberRegex)) {
                if (textView3!!.text != "") {
                    textView3!!.text = calculationAnswerFunction()
                } else
                    textView3!!.text = textView1!!.text
            }
            textView2!!.text = "+"
            textView1!!.text = ""
        }
        if (buttonSubtract!!.isPressed){
            if (textView1!!.text.matches(numberRegex)) {
                if (textView3!!.text != ""){
                    textView3!!.text = calculationAnswerFunction()
                } else
                    textView3!!.text = textView1!!.text
            }
            textView2!!.text = "-"
            textView1!!.text = ""
        }
    }
}