package com.example.app_gorjeta

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.app_gorjeta.databinding.SummeryactivityBinding

class Summeryactivity : AppCompatActivity() {

    private lateinit var binding: SummeryactivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SummeryactivityBinding.inflate(layoutInflater)

        setContentView(binding.root)
        val totalTable = intent.getFloatExtra("totalTable", 0.0f)
        val nPeople = intent.getIntExtra("nPeople", 0)
        val percentage = intent.getIntExtra("percentage", 0)
        val totalFinal = intent.getFloatExtra("totalFinal", 0.0f)

        binding.tvValuePercetage.text = percentage.toString()
        binding.tvTotalAmount.text = totalTable.toString()
        binding.tvTotalPeople.text = nPeople.toString()
        binding.tvTotalamount.text = totalFinal.toString()

        binding.btnRefresh.setOnClickListener {
            finish()
        }


    }
}