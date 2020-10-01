package com.light.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button


class MainActivity : AppCompatActivity(), View.OnClickListener {
    private val btnMoveActivity: Button by lazy { findViewById<Button>(R.id.move_activity) }
    private val btnMoveWithData by lazy { findViewById<Button>(R.id.move_activity_data) }
    private val btnMoveWithObject by lazy { findViewById<Button>(R.id.move_activity_object) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnMoveWithObject.setOnClickListener(this)
        btnMoveActivity.setOnClickListener(this)
        btnMoveWithData.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.move_activity -> {
                val moveIntent = Intent(this@MainActivity, MoveActivity::class.java)
                startActivity(moveIntent)
            }
            R.id.move_activity_data -> {
                val moveIntent = Intent(this@MainActivity, MoveWithData::class.java)
                moveIntent.putExtra(MoveWithData.EXTRA_NAME, "Amal Nur Alam")
                moveIntent.putExtra(MoveWithData.EXTRA_AGE, 18)
                startActivity(moveIntent)
            }
            R.id.move_activity_object -> {
                val person = Person(
                    name = "Amal Nur Alam",
                    age = 18,
                    city = "Bandung",
                    email = "amalnuralam8@gmail.com"
                )
                val moveIntent = Intent(this@MainActivity, MoveWithObject::class.java)
                moveIntent.putExtra(MoveWithObject.EXTRA_PERSON, person)
                startActivity(moveIntent)
            }
        }
    }
}
