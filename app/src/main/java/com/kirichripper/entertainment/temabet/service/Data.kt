package com.kirichripper.entertainment.temabet.service

import android.app.Service
import android.content.Intent
import android.os.*

import android.util.JsonReader
import com.example.temabet.R
import kotlinx.android.parcel.Parcelize
import kotlinx.coroutines.Dispatchers

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import org.json.JSONObject

import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URL
import java.nio.charset.StandardCharsets
import java.security.MessageDigest


import kotlinx.coroutines.launch

//@Parcelize
//data class UserDataMap(
//    val map: Map<String, Parcelable?> = hashMapOf()
//) : Parcelable, Map<String, Parcelable?> by map

final class Data : Service() {

    private var task: Job? = null
    private var userId: Int? = null;
    private var error: Int? = null;
    private var arb_err: String? = null;

    var done = false;

    private fun user(): Bundle? {
        if (done) {
            val resp = Bundle()
            resp.putString("arb_err",arb_err)
            if (error != null) resp.putInt("error",error!!)
            if (userId != null) resp.putInt("id",userId!!)

            //return UserDataMap(mapOf<String,Parcelable?>("id" to userId,"error" to error, "arb_err" to aerrB))
            return resp
        }
        else return null
    }


    override fun onCreate() {
        super.onCreate()
    }

    //This is where the intent from start service goes.
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        /*val supErrC =*/
        super.onStartCommand(intent, flags, startId) //error code

        this.task = GlobalScope.launch(Dispatchers.IO) {
            val Login: String? = intent?.getStringExtra("login")
            val password: String? = intent?.getStringExtra("password")

            val url = URL("http",getString(R.string.serverUrl),"8080")
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
                    403 -> {
                        error = code
                    }
                    500 -> {
                        error = code
                    }
                    200 -> {
                        val respBodyReader = JsonReader(InputStreamReader(ist))
                        if (respBodyReader.nextName() == "id") {
                            val id: Int? = respBodyReader.nextInt()
                            userId = id!!
                        } else {
                            arb_err = "malformed json response in Ok response"
                        }
                    }
                    else -> {

                        arb_err = "unexpected http code"
                    }
                };
            }
            done = true;
        }
        return START_STICKY
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
        //return Binder()
        val self = this;

        return object: Binder() {
            override fun onTransact(code: Int, data: Parcel, reply: Parcel?, flags: Int): Boolean {
                if (flags != 0) return false
                if (reply == null) return false

                //return super.onTransact(code, data, reply, flags)
                when (code) {
                    2->  {
                        val d = self.user()
                        if (d == null) {
                            reply.writeString("wait")
                        } else {
                            d.writeToParcel(reply, 0)
                        }
                        return true
                    }
                    else -> {
                        return false
                    }
                }

            }
        }
    }

}



