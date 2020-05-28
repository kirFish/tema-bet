package com.kirichripper.entertainment.temabet.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.kirichripper.entertainment.temabet.R
import kotlinx.android.synthetic.main.activity_runs.*

class Runs : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_runs)


        initRunsList()
    }

    private fun initRunsList() {

        //don't want extendable view
        runsList.setHasFixedSize(true)

        //just like list in one column
        runsList.layoutManager = LinearLayoutManager(applicationContext)



    }
}
