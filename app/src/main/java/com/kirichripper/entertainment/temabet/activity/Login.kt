package com.example.temabet.activity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.temabet.R
import kotlinx.android.synthetic.main.activity_login.*

class Login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        startCredentialsCheck()
    }


    private fun startCredentialsCheck() {

        //Because by default edit text contains zero
        var passwordReady = false;
        var loginReady = false;
        var ifCredentialsReady = false;

//        while(!ifCredentialsReady){
//
//            loginReady = checkLogin()
//            passwordReady = checkPassword()
//
//            if(loginReady){
//                inputLogin.highlightColor = getColor(R.color.editTextCorrect)
//            }
//
//            if(passwordReady){
//                inputPassword.highlightColor = getColor(R.color.editTextCorrect)
//            }
//
//            if(loginReady && passwordReady){
//                ifCredentialsReady = true
//            }
//        }
    }

    private fun checkLogin(): Boolean = inputLogin.text.isEmpty() && (inputLogin.text.length < 45)


    private fun checkPassword(): Boolean = inputPassword.text.isEmpty()


    fun startSignIn(view : android.view.View){

        if(checkLogin() && checkPassword()){
            Toast.makeText(applicationContext,"Check input data",Toast.LENGTH_LONG).show()
        }else{

            mainLoginLayout.visibility = View.INVISIBLE;
            secondaryLoginLayout.visibility = View.VISIBLE;
            //this.startService()
        }
    }



}
