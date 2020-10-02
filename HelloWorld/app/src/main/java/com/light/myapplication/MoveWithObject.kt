package com.light.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MoveWithObject : AppCompatActivity() {
    private val tvObject by lazy { findViewById<TextView>(R.id.tv_data_recived) }

    companion object{
        const val EXTRA_PERSON = "extra_person"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_object)

        val person = intent.getParcelableExtra<Person>(EXTRA_PERSON)
        val text = "Name: ${person?.name}, \nEmail: ${person?.email}, \nAge: ${person?.age},\nLocation: ${person?.city}"
        tvObject.text = text

    }
}