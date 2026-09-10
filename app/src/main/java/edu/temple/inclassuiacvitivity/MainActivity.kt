package edu.temple.inclassuiacvitivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner = findViewById<Spinner>(R.id.spinner)
        val displayTextView = findViewById<TextView>(R.id.textDisplay)
        
        //val numberArray = Array Of Numbers
        val numberArray = Array(20){(it + 1)* 5}

        //spinner.adapter = ArrayAdapter...
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, numberArray.toList())
        spinner.adapter = adapter

        //spinner.onItemSelectedListener = object: ...
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ){
                displayTextView.textSize = parent?.getItemAtPosition(position).toString().toFloat()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                //nothing to do here
            }
        }
    }
}