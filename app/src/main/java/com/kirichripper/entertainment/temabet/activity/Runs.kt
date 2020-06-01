package com.kirichripper.entertainment.temabet.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.kirichripper.entertainment.temabet.R
import com.kirichripper.entertainment.temabet.adapter.RunAdapter
import com.kirichripper.entertainment.temabet.service.initRunList
import kotlinx.android.synthetic.main.activity_runs.*

class Runs : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_runs)


        initRunsList()
    }

    private fun initRunsList() {

        runsList.setHasFixedSize(true)
        runsList.layoutManager = LinearLayoutManager(applicationContext)
        runsList.adapter = RunAdapter(initRunList(), this)


    }
}
