package com.light.mybackgrounduithread


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import java.lang.Exception


class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvStatus = findViewById<TextView>(R.id.tv_status)
        val tvDesc = findViewById<TextView>(R.id.tv_desc)

        tv_status.setText(R.string.status_pre)
        tvStatus.text = INPUT_STRING

        GlobalScope.launch(Dispatchers.IO){
            val input = INPUT_STRING
            var output: String? = null

            Log.d(LOG_ASYNC, "onCreate: ")

            try {
                // Input stringnya ditambahkan dengan string ' Selamat Belajar!!"
                output = "$input Selamat Belajar!!"
                delay(2000)

                //pindah ke Main thread untuk update UI
                withContext(Dispatchers.Main) {
                    tvStatus.setText(R.string.status_post)
                    tvDesc.text = output
                }
            } catch (e: Exception) {
                Log.d(LOG_ASYNC, e.message.toString())
            }

        }
    }





    companion object{
        private const val INPUT_STRING = "Halo ini Demo AsyncTasc"
        private const val LOG_ASYNC = "DemoAsync"
    }
}
