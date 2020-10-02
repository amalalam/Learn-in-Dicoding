package com.light.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), View.OnClickListener {
    private val btnMoveActivity: Button by lazy { findViewById<Button>(R.id.move_activity) }
    private val btnMoveWithData by lazy { findViewById<Button>(R.id.move_activity_data) }
    private val btnMoveWithObject by lazy { findViewById<Button>(R.id.move_activity_object) }
    private val btnDialNumber by lazy { findViewById<Button>(R.id.dial_number) }
    private val btnMoveForResult by lazy{ findViewById<Button>(R.id.move_for_result)}
    private lateinit var tvResult: TextView

    companion object{
        private const val TAG = "MyActivity"
        private const val REQUEST_CODE = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        btnMoveWithObject.setOnClickListener(this)
        btnMoveActivity.setOnClickListener(this)
        btnMoveWithData.setOnClickListener(this)
        btnDialNumber.setOnClickListener(this)
        btnMoveForResult.setOnClickListener(this)

        tvResult = findViewById(R.id.tv_result)

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
            R.id.dial_number -> {
                val phoneNumber = "+6282117843757"
                val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(dialPhoneIntent)
            }
            R.id.move_for_result -> {
                val moveForResult = Intent(this@MainActivity, MoveForResult::class.java)
                Log.d(TAG, "Activity Move for Result Dijalankan")
                startActivity(moveForResult)
            }
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

//        we have some error in onActivity Result

        super.onActivityResult(requestCode, resultCode, data)
        Log.d(TAG, "On Activity Result Dijalankan ")

        if(requestCode == REQUEST_CODE){
            if(resultCode == MoveForResult.RESULT_CODE){
                val selectedValue = data?.getIntExtra(MoveForResult.EXTRA_SELECTED_VALUE, 0)
                Log.d(TAG, "Hasil: $selectedValue")
                tv_result.text = "Hasil: $selectedValue"
            }
        }

    }
}


