package com.example.app_gorjeta

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.app_gorjeta.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        var percentage: Int = 0

        binding.rboptionone.setOnCheckedChangeListener{_,isChecked ->
            if(isChecked){
                percentage = 10
            }
        }

        binding.rboptiontwo.setOnCheckedChangeListener{_,isChecked ->
            if(isChecked){
                percentage = 15
            }
        }

        binding.rboptionthree.setOnCheckedChangeListener{_,isChecked ->
            if(isChecked){
                percentage = 20
            }
        }


        binding.btnClean.setOnClickListener {

            binding.tieTotal.setText("")
            binding.tieNumberP.setText("")
            binding.rgPercetege.clearCheck()

        }

        binding.btnCalcular.setOnClickListener {

            val totalTableTemp = binding.tieTotal.text
            val NpeopleTemp = binding.tieNumberP.text

            if(totalTableTemp?.isEmpty() == true || NpeopleTemp?.isEmpty() == true ){
                Snackbar
                    .make(binding.tieTotal, "Preencha os campos", Snackbar.LENGTH_LONG).show()
            } else {

            val totalTable : Float = totalTableTemp.toString().toFloat()
            val nPeople : Int = NpeopleTemp.toString().toInt()

            val totalAmount = totalTable / nPeople
            val tips = totalAmount * percentage / 100
            val totalFinal = totalAmount + tips
            println("O total por pessoa é " + totalFinal.toString() + " reais")
             }
        }


    }
}