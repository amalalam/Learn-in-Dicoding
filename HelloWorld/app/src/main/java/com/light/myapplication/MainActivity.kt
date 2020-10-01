package com.light.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button


class MainActivity : AppCompatActivity(), View.OnClickListener {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMoveActivity = findViewById<Button>(R.id.moveActivity)
        btnMoveActivity.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.moveActivity -> {
                val moveIntent = Intent(this@MainActivity, MoveActivity::class.java)
                startActivity(moveIntent)
            }
        }
    }
}
