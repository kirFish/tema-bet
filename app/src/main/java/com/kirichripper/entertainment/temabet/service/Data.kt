package com.example.temabet.service

import android.annotation.SuppressLint
import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.JsonReader
import com.example.temabet.R
import org.json.JSONObject
import java.io.InputStreamReader
//import sun.net.www.http.HttpClient
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URL
import java.nio.charset.StandardCharsets
import java.security.MessageDigest



class Data : Service() {
    private var userId: Int? = null;
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
        //return supErrC
        //val init: ServiceInitMsg? = intent?.getParcelableExtra("serviceInit")

        val Login: String? = intent?.getParcelableExtra("login")
        val password: String? = intent?.getParcelableExtra("password")

        var threadHandle = Thread {
            val url = URL(getString(R.string.serverUrl) + getString(R.string.loginHandler))

            with(url.openConnection() as HttpURLConnection) {
                requestMethod = "GET"
                val reqBody = JSONObject()
                reqBody.put("login",Login)
                val digest: MessageDigest = MessageDigest.getInstance("SHA-256")
                val encHash = digest.digest(password!!.toByteArray(StandardCharsets.UTF_8))
                reqBody.put("passwh",encHash)

                val wr = OutputStreamWriter(outputStream)
                wr.write(reqBody.toString())
                wr.flush()

                val ist = inputStream
                val code = responseCode

                when (code) {
                    404 -> {
                        //TODO: No such user case
                    }
                    500 -> {
                        //TODO: ISE
                    }
                    200 -> {
                        val respBodyReader = JsonReader(InputStreamReader(ist))


                    }
                    else -> {
                        //TODO: impossible
                    }
                };


                //val respBody = JSONObject(ist)
            }

        }


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
