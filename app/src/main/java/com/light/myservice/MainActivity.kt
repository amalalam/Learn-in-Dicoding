package com.light.myservice

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_start_service.setOnClickListener(this)
        btn_start_bound_service.setOnClickListener(this)
        btn_start_intent_service.setOnClickListener(this)
        btn_stop_bound_service.setOnClickListener(this)


    }

    private var mServiceBound = false
    private lateinit var mBoundService: MyBoundService

    private var mServiceConnection = object: ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            val myBinder = service as MyBoundService.MyBinder
            mBoundService = myBinder.getService
            mServiceBound = true
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            mServiceBound = false
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if(mServiceBound){
            unbindService(mServiceConnection)
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_start_service -> {
                val mStartServiceIntent = Intent(this, MyService::class.java)
                startService(mStartServiceIntent)
            }
            R.id.btn_start_intent_service -> {
                val mIntentService = Intent(this, MyIntentService::class.java)
                mIntentService.putExtra(MyIntentService.EXTRA_DURATION, 5000L)
                startService(mIntentService)
            }
            R.id.btn_start_bound_service -> {
                val mIntentBoundService = Intent(this, MyBoundService::class.java)
                bindService(mIntentBoundService, mServiceConnection , Context.BIND_AUTO_CREATE)

            }
            R.id.btn_stop_bound_service -> {
                unbindService(mServiceConnection)
            }

        }
    }
}