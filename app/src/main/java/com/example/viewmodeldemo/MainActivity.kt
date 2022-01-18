package com.example.viewmodeldemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val text: TextView = findViewById(R.id.tv1)
        val viewM = ViewModelProvider(this).get(MainVM::class.java)

        text.setOnClickListener {
            viewM.timerValue.value = 10000
            viewM.startTime(applicationContext)
        }

        viewM.secondsLeft.observe(this, Observer {
            Toast.makeText(applicationContext, "observer", Toast.LENGTH_SHORT).show()
            text.text = it.toString()
        })

        val button: Button = findViewById(R.id.button)

        button.setOnClickListener {
            viewM.increment()
        }
    }
}