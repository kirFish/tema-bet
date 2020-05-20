package com.example.temabet.service

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.os.IInterface
import android.os.Parcel
import java.io.FileDescriptor
import java.io.PrintWriter

//const val adress = "127.0.0.1:8080"

class Data : Service() {

//    class DataBinder : Binder() {
//        override fun onTransact(code: Int, data: Parcel, reply: Parcel?, flags: Int): Boolean {
//            return super.onTransact(code, data, reply, flags)
//        }
//
//        override fun dump(fd: FileDescriptor, fout: PrintWriter, args: Array<out String>?) {
//            super.dump(fd, fout, args)
//        }
//    }


    override fun onCreate() {
        super.onCreate()

    }

    //This is where the intent from start service goes.
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val supErrC = super.onStartCommand(intent, flags, startId) //error code
        supErrC
    }

    override fun onDestroy() {
        super.onDestroy()
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
