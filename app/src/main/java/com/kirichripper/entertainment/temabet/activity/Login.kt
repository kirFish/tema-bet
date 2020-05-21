package com.example.temabet.activity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.temabet.R

class Login : AppCompatActivity() {

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        startCredentialsCheck()

    }


    private fun startCredentialsCheck() {

        //Because by default edit text contains zero
        var ifCredentialsReady = false;

       // while(!ifCredentialsReady){

//            if(checkPassword()) && checkLogin()){
//                ifCredentialsReady = true;
//            }
        //}
    }

    private fun checkLogin(): Boolean {
        TODO("Not yet implemented")
    }

    private fun checkPassword(): Boolean {
        TODO("Not yet implemented")
    }

    public fun startSignIn(view : android.view.View){


        //this.startService()
    }



}
