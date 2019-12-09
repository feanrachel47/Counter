package com.example.counter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //1. declare an instant of ViewModel
    private lateinit var viewModel: CounterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //2. initialise ViewModel ; provider = new, providers = old;
        viewModel = ViewModelProviders.of(this).get(CounterViewModel::class.java)

        buttonIncrement.setOnClickListener{
            viewModel.increment()
            textViewCounter.text = viewModel.counter.value.toString()
        }


        //add observer
        viewModel.counter.observe( this, Observer<Int>{
            if(viewModel.counter.value==10)endGame()
        }

        )

        buttonDecrement.setOnClickListener{
            viewModel.decrement()
            textViewCounter.text = viewModel.counter.value.toString()
        }
    }

    private fun endGame(){
        Toast.makeText(applicationContext, "Counter==10", Toast.LENGTH_LONG).show()
    }
}
