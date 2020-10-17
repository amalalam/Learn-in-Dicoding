package com.light.myservice

import android.app.Service
import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.os.Binder
import android.os.CountDownTimer
import android.os.IBinder
import android.util.Log

class MyBoundService : Service() {

    private var mBinder = MyBinder()
    private val startTime = System.currentTimeMillis()
    internal inner class MyBinder: Binder(){

        val getService: MyBoundService = this@MyBoundService
    }
    override fun onBind(intent: Intent): IBinder {
        Log.d(TAG, "onBind: ")
        mTimer.start()
        return mBinder
    }

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "onCreate: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: ")
    }

    override fun onUnbind(intent: Intent?): Boolean {
        Log.d(TAG, "onUnbind: ")
        mTimer.cancel()
        return super.onUnbind(intent)
    }

    override fun onRebind(intent: Intent?) {
        super.onRebind(intent)
        Log.d(TAG, "onRebind: ")
    }
    
    private var mTimer: CountDownTimer = object: CountDownTimer(100000, 1000){
        override fun onTick(l: Long) {
            val elapsedTime = System.currentTimeMillis() - startTime
            Log.d(TAG, "onTick: $elapsedTime")
        }

        override fun onFinish() {
            TODO("Not yet implemented")
        }
    }

    companion object{
        private const val TAG = "MyBoundService"
    }
}