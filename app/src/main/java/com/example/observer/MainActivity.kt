package com.example.observer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //Declare multi-level variable
    private lateinit var counterViewModel: CounterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("MainActivity","onCreated")

        //Initialise View Model
        counterViewModel = ViewModelProviders.of(this).get(CounterViewModel::class.java)

        //Add an obeserver to the counter  or (it)
        counterViewModel.getCounter.observe(this, Observer {
            if(it.equals((4))) goodLuck()
        })


        textViewCounter.text = counterViewModel.getCounter.value.toString()

        buttonIncrement.setOnClickListener{
            counterViewModel.increment()
            textViewCounter.text = counterViewModel.getCounter.value.toString()
        }

        buttonDecrement.setOnClickListener{
            counterViewModel.decerement()
            textViewCounter.text = counterViewModel.getCounter.value.toString()
        }
    }

    private fun goodLuck() {
        Toast.makeText(applicationContext,"Good Luck!!!",Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        Log.d("MainActivity", "onDestroy")
        super.onDestroy()
    }
}
