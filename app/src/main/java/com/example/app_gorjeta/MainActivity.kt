package com.example.app_gorjeta

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
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

        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.num_people,
            android.R.layout.simple_spinner_item
        )

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spnierNpeople.adapter = adapter

        var numofpeople = 0
        binding.spnierNpeople.onItemSelectedListener =

            object : AdapterView.OnItemSelectedListener{
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view : View?,
                    position : Int,
                    id : Long) {
                    numofpeople = position
                }
                override fun onNothingSelected(parent: AdapterView<*>?) {

                }
            }

        binding.btnClean.setOnClickListener {

            binding.tieTotal.setText("")
            binding.rgPercetege.clearCheck()

        }

        binding.btnCalcular.setOnClickListener {

            val totalTableTemp = binding.tieTotal.text


            if(totalTableTemp?.isEmpty() == true){
                Snackbar
                    .make(binding.tieTotal, "Preencha os campos", Snackbar.LENGTH_LONG).show()
            } else {

            val totalTable : Float = totalTableTemp.toString().toFloat()
            val nPeople : Int = numofpeople

            val totalAmount = totalTable / nPeople
            val tips = totalAmount * percentage / 100
            val totalFinal = totalAmount + tips


            val intent = Intent(this, Summeryactivity::class.java)
                intent.apply {
                    putExtra("totalTable", totalTable)
                    putExtra("nPeople", numofpeople)
                    putExtra("percentage", percentage)
                    putExtra("totalFinal",totalFinal)
                }
                startActivity(intent)

             }
        }


    }


}