package com.light.myservice

import android.app.IntentService
import android.content.Intent
import android.content.Context
import android.util.Log

@Suppress("DEPRECATION")
class MyIntentService : IntentService("MyIntentService") {

    companion object{
        internal const val EXTRA_DURATION = "extra_duration"
        private const val TAG = "MyIntentService"
    }

    override fun onHandleIntent(intent: Intent?) {
        Log.d(TAG, "onHandleIntent: Mulai")
        val duration = intent?.getLongExtra(EXTRA_DURATION, 0) as Long
        try{
            Thread.sleep(duration)
            Log.d(TAG, "onHandleIntent: Selesai...")
        } catch(e: Exception){
            e.printStackTrace()
            Thread.currentThread().interrupt()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: Intent Service")
    }
}