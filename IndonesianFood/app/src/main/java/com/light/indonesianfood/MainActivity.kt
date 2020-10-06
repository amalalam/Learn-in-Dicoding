package com.light.indonesianfood

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.ProxyFileDescriptorCallback
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var list: ArrayList<Foods> = arrayListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_food.setHasFixedSize(true)

        list.addAll(FoodsData.listData)
        showRecyclerList()
    }



    private fun showRecyclerList() {
        rv_food.layoutManager = LinearLayoutManager(this)
        val listFoodsAdapter = ListFoodsAdapter(list)
        rv_food.adapter = listFoodsAdapter

        listFoodsAdapter.setOnItemClickCallback(object: ListFoodsAdapter.OnItemClickCallback{
            override fun onItemClicked(data: Foods) {
                showSelectedFoods(data)
            }
        })
    }

    private fun showSelectedFoods(foods: Foods) {
        Toast.makeText(this, "Kamu memilih " + foods.name, Toast.LENGTH_SHORT).show()
        Log.d("MainActivity", "showSelectedFoods:${foods.name} " )
        val name  = resources.getStringArray(R.array.data_name)
        val detail  = resources.getStringArray(R.array.data_description)
        val photo  = resources.getStringArray(R.array.src_photo)

        var inc = 0
        for (index in name){
            if (index == foods.name){
                val foodsWithObjectIntent = Intent(this, FoodsWithObjectActivity::class.java)
                val foods = Foods(
                    name = name[inc]
                    , detail = detail[inc]
                )
//                val image = Foods( photo = photo[inc])
//                )
                Log.d("Inside For", "photo: ${name[inc]}")
                foodsWithObjectIntent.putExtra(FoodsWithObjectActivity.EXTRA_FOOD, foods)
//                foodsWithObjectIntent.putExtra("images1", image)
                startActivity(foodsWithObjectIntent)
                break
            }
            inc++
        }

    }


}