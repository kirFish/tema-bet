package com.example.temabet.service

import android.app.Service
import android.content.Intent
import android.os.IBinder

class Data : Service() {

    override fun onCreate() {

    }

    override fun onDestroy() {

    }
    //Called if all activities dead
    override fun onUnbind(intent: Intent?): Boolean {
        return false
    }
    //called ONCE, for getting IBinder handler
    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }
}
