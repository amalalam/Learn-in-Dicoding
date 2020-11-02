package com.light.myworkmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.work.*
import kotlinx.android.synthetic.main.activity_main.*
import androidx.work.Data.Builder
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var periodicWorkRequest: PeriodicWorkRequest

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnOneTimeTask.setOnClickListener(this)
        btnPeriodicTask.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btnOneTimeTask -> startOneTimeTask()
            R.id.btnPeriodicTask -> startPeriodicTask()
            R.id.btnCancelTask -> cancelPeriodicTask()
        }
    }

    private fun startOneTimeTask(){
        textStatus.text = getString(R.string.status)

        val city = editCity.text.toString()
        val data = Builder()
                .putString(MyWorker.EXTRA_CITY, city)
                .build()
        val constraint = Constraints.Builder()
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .build()
        val oneTimeWorkRequest = OneTimeWorkRequest.Builder(MyWorker::class.java)
                .setInputData(data)
                .setConstraints(constraint)
                .build()
        WorkManager.getInstance().enqueue(oneTimeWorkRequest)
        WorkManager.getInstance().getWorkInfoByIdLiveData(oneTimeWorkRequest.id).observe(this@MainActivity, { workInfo ->
            val status = workInfo.state.name
            textStatus.append("\n" + status)
        })
    }

    private fun startPeriodicTask(){
        textStatus.text = getString(R.string.status)
        val data = Builder()
                .putString(MyWorker.EXTRA_CITY, editCity.text.toString())
                .build()
        val constraints = Constraints.Builder()
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .build()
        periodicWorkRequest = PeriodicWorkRequest.Builder(MyWorker::class.java, 15 , TimeUnit.MINUTES)
                .setInputData(data)
                .setConstraints(constraints)
                .build()
        WorkManager.getInstance().enqueue(periodicWorkRequest)
        WorkManager.getInstance().getWorkInfoByIdLiveData(periodicWorkRequest.id).observe(this, object: Observer<WorkInfo>{
            override fun onChanged(workInfo: WorkInfo) {
                val status = workInfo.state.name
                textStatus.append("\n" + status)
                btnCancelTask.isEnabled = false
                if(workInfo.state == WorkInfo.State.ENQUEUED){
                    btnCancelTask.isEnabled = true
                }
            }
        })
    }

    private fun cancelPeriodicTask(){
        WorkManager.getInstance().cancelWorkById(periodicWorkRequest.id)
    }


}