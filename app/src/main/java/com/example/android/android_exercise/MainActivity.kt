package com.example.android.android_exercise

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val enterName = findViewById<EditText>(R.id.enterName)
        val welcomeName = findViewById<TextView>(R.id.txtWelcome)
        val subButt = findViewById<Button>(R.id.btnSubmit)
        val nextButt = findViewById<Button>(R.id.btnNext)
        var enteredName = ""

        subButt.setOnClickListener {
            enteredName = enterName.text.toString()
            if (enteredName == "") {
                nextButt.visibility = View.INVISIBLE
                welcomeName.text = ""
                Toast.makeText(this@MainActivity, "Please enter your name", Toast.LENGTH_SHORT)
                    .show()
            } else {
                val message = "Welcome $enteredName"
                welcomeName.text = message
                enterName.text.clear()
                nextButt.visibility = View.VISIBLE


                nextButt.setOnClickListener {
                    val intent = Intent(this,SecondActivity::class.java)
                    intent.putExtra("USER",enteredName)
                    startActivity(intent)
                }
            }
        }

    }
}