package com.example.temabet.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import com.example.temabet.R
import kotlinx.android.synthetic.main.activity_login.*

class Login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

       // while(check)
    }

    fun checkCredintalsStatus() : Boolean = inputLogin.text.isEmpty() && inputPassword.text.isEmpty()
 }
