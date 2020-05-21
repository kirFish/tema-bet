package com.example.temabet.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Toast
import com.example.temabet.R
import kotlinx.android.synthetic.main.activity_login.*

class Login : AppCompatActivity() {

    private val handler = Handler()

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

        class MyRunnable(var handler: Handler) : Runnable {

            override fun run() {

                loginReady = checkLogin()
                passwordReady = checkPassword()

                if (loginReady) {
                    inputLogin.setBackgroundColor(getColor(R.color.editTextCorrect))
                }else{
                    inputLogin.setBackgroundColor(getColor(R.color.editTextWrong))

                }

                if (passwordReady) {
                    inputPassword.setBackgroundColor(getColor(R.color.editTextCorrect))
                }else{
                    inputPassword.setBackgroundColor(getColor(R.color.editTextWrong))
                }

                if (loginReady && passwordReady) {
                    ifCredentialsReady = true
                }

                handler.postDelayed(this, 1000)
            }

        }

        handler.post(MyRunnable(handler))

    }


    private fun checkLogin(): Boolean = inputLogin.text.isNotEmpty() && (inputLogin.text.length < 45)


    private fun checkPassword(): Boolean = inputPassword.text.isNotEmpty()


    fun startSignIn(view : android.view.View){


        if(checkPassword() && checkLogin()){

            mainLoginLayout.visibility = View.INVISIBLE;
            secondaryLoginLayout.visibility = View.VISIBLE;
            //this.startService()
        }else{

            Toast.makeText(applicationContext,"Check input data",Toast.LENGTH_LONG).show()

        }
    }




}
