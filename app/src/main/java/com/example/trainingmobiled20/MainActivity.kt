package com.example.trainingmobiled20

import android.R.id
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textSearch.visibility = View.INVISIBLE
    }

    fun search(view: View) {
        textSearch.visibility = View.VISIBLE
        theTicket.visibility = View.INVISIBLE
    }


}