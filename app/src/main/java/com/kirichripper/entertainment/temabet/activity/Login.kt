package com.kirichripper.entertainment.temabet.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Toast
import com.example.temabet.R
import com.kirichripper.entertainment.temabet.activity.Runs
import kotlinx.android.synthetic.main.activity_login.*

class Login : AppCompatActivity() {

    //special runnable for controlling the UI
    private val colorHandler = Handler()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //this starts the handler who controls the color of editText
        startCredentialsCheck()
    }


     fun startSignIn(view : android.view.View){


        if(checkPassword() && checkLogin()){

            //changed the view to progress bar
            mainLoginLayout.visibility = View.INVISIBLE
            secondaryLoginLayout.visibility = View.VISIBLE

            //startService()
            //var responseFromServer = Data.startLogin(inputLogin.text, inputPassword.text)

            // for testing cos service is not ready yet to work with API
            var responseFromServer = true

            //If response is true then the user is logged in
            if(responseFromServer){

                val intent = Intent(this, Runs::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(applicationContext,"Incorrect login or password ",Toast.LENGTH_LONG).show()
            }
        }else{

            Toast.makeText(applicationContext,"Check input data",Toast.LENGTH_LONG).show()

        }
    }


    private fun checkLogin(): Boolean = inputLogin.text.isNotEmpty() && (inputLogin.text.length < 45)


    private fun checkPassword(): Boolean = inputPassword.text.isNotEmpty()


    private fun startCredentialsCheck() {

        //Because by default edit text contains zero
        var ifCredentialsReady = false

        class MyRunnable(var handler: Handler) : Runnable {

            override fun run() {

                var loginReady = checkLogin()
                var passwordReady = checkPassword()

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

                handler.postDelayed(this, 500)
            }

        }

        colorHandler.post(MyRunnable(colorHandler))

    }
}
