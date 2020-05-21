package com.example.temabet.activity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import com.example.temabet.R
import kotlinx.android.synthetic.main.activity_login.*

class Login : AppCompatActivity() {

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        startCredentialsCheck()

    }


    private fun startCredentialsCheck() {

    }

    public fun startSignIn(view : android.view.View){


        //this.startService()
    }



}
