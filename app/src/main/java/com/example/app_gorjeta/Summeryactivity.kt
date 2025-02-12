package com.example.app_gorjeta

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Summeryactivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.summeryactivity)
        val totalTable = intent.getFloatExtra("totalTable", 0.0f)
        val nPeople = intent.getIntExtra("nPeople", 0)
        val percentage = intent.getIntExtra("percentage", 0)
        val totalFinal = intent.getFloatExtra("totalFinal", 0.0f)


    }
}