package com.kirichripper.entertainment.temabet.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.kirichripper.entertainment.temabet.R
import kotlinx.android.synthetic.main.activity_history.*

class History : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        initHistoryList()
    }

    private fun initHistoryList() {

        //don't want extendable view
        historyList.setHasFixedSize(true)

        //just like list in one column
        historyList.layoutManager = LinearLayoutManager(applicationContext)



    }
}
