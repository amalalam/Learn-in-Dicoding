package com.light.myservice

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import kotlinx.coroutines.*
import java.lang.UnsupportedOperationException

class MyService : Service() {

    override fun onBind(intent: Intent): IBinder {
        throw UnsupportedOperationException("Not yet Implemented")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d(TAG, "Service Dijalankan ")
        GlobalScope.launch{
            delay(3000)
            stopSelf()
            Log.d(TAG, "Service Dihentikan")
        }
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }

    companion object{
        private const val TAG = "MyService"
    }
}