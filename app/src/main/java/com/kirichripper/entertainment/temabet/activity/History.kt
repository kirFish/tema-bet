package com.kirichripper.entertainment.temabet.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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

        //History loading....
        secondaryHistoryLayout.visibility = View.VISIBLE
        primaryHistoryLayout.visibility = View.INVISIBLE

        //

        //don't want extendable view
        historyList.setHasFixedSize(true)

        //just like list in one column
        historyList.layoutManager = LinearLayoutManager(applicationContext)



    }
}
