package com.light.myunittesting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mainViewModel: MainViewModel

    private lateinit var edtWidth: TextView
    private lateinit var edtHeight: TextView
    private lateinit var edtLength: TextView
    private lateinit var tvResult: TextView
    private val btnCalculateVolume: Button by lazy { findViewById(R.id.btn_calculate_volume) }
    private val btnCalculationCircumference: Button by lazy{ findViewById(R.id.btn_calculate_circumference) }
    private val btnCalculateSurfaceArea: Button by lazy { findViewById(R.id.btn_calculate_surface_area) }
    private val btnSave: Button by lazy {findViewById(R.id.btn_save)}
    
    companion object{
        private const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvResult.text = "Something"

        mainViewModel = MainViewModel(CuboidModel())

        edtWidth = findViewById(R.id.edt_width)
        edtHeight = findViewById(R.id.edt_height)
        edtLength = findViewById(R.id.edt_length)
        tvResult = findViewById(R.id.tv_result)

        btnCalculateSurfaceArea.setOnClickListener(this)
        btnCalculateVolume.setOnClickListener(this)
        btnCalculationCircumference.setOnClickListener(this)
        btnSave.setOnClickListener(this)


    }


    override fun onClick(v: View?) {
        val length = edtLength.text.toString()
        val width = edtWidth.text.toString()
        val height = edtHeight.text.toString()

        when{
            length.isEmpty() -> edtLength.error = "Field ini tidak boleh kosong"
            height.isEmpty() -> edtHeight.error = "Field ini tidak boleh kosong"
            width.isEmpty() -> edtWidth.error = "Field ini tidak boleh kosong"

            else -> {
                val l = length.toDouble()
                val h = height.toDouble()
                val w = width.toDouble()

                when{
                    v?.id == R.id.btn_save -> {
                        Log.d(TAG, "Apakah save dijalankan? ")
                        mainViewModel.save(w, l, h)
                        visible()
                    }
                    v?.id == R.id.btn_calculate_circumference -> {
                        Log.d(TAG, "btnCalculateCircumference Dijalankan ")
                        tvResult.text = mainViewModel.getCircumference().toString()
                        gone()
                    }
                    v?.id == R.id.btn_calculate_surface_area -> {
                        tvResult.text = mainViewModel.getSurfaceArea().toString()
                        gone()
                    }
                    v?.id == R.id.btn_calculate_volume -> {
                        tvResult.text = mainViewModel.getVolume().toString()
                        gone()
                    }
                }
            }
        }

    }

    private fun visible() {
        btnCalculateVolume.visibility = View.VISIBLE
        btnCalculationCircumference.visibility = View.VISIBLE
        btnCalculateSurfaceArea.visibility = View.VISIBLE
        btnSave.visibility = View.GONE
    }
    private fun gone() {
        btnCalculateVolume.visibility = View.GONE
        btnCalculationCircumference.visibility = View.GONE
        btnCalculateSurfaceArea.visibility = View.GONE
        btnSave.visibility = View.VISIBLE
    }

}