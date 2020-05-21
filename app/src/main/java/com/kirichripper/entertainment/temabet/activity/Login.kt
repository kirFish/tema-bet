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

        //setting default color to red
        inputLogin.highlightColor = R.color.editTextWrong
        inputPassword.highlightColor = R.color.editTextWrong
    }


//TODO:
//Add onclick reaction which will ask if the credentials are correct
// unnecessary garbage
//
//    val CredentialsStatus = inputLogin.text.isEmpty() && inputPassword.text.isEmpty();
//
//    fun login(view: android.view.View) {
//
//    }

}
