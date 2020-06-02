package com.kirichripper.entertainment.temabet.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
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
        val layoutManager = LinearLayoutManager(applicationContext)
        runsList.layoutManager = layoutManager
//        val dividerItemDecoration = DividerItemDecoration(runsList.context, layoutManager.orientation)
//        dividerItemDecoration.setDrawable(applicationContext.resources.getDrawable(R.drawable.divider_item_decoration))
//        runsList.addItemDecoration(dividerItemDecoration)
        runsList.adapter = RunAdapter(initRunList(), this)


    }
}
