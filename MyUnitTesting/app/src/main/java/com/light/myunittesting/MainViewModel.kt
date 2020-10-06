package com.light.myunittesting

class MainViewModel(private val cuboidModel: CuboidModel) {

    fun getVolume(): Double = cuboidModel.getVolume()

    fun getCircumference(): Double = cuboidModel.getCircumference()

    fun getSurfaceArea(): Double = cuboidModel.getSurfaceArea()

    fun save(w: Double, l:Double, h:Double)= cuboidModel.save(w, l, h)
}