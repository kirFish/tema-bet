package com.kirichripper.entertainment.temabet.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.kirichripper.entertainment.temabet.R
import com.kirichripper.entertainment.temabet.adapter.HorseAdapter
import com.kirichripper.entertainment.temabet.service.initHorsesList
import kotlinx.android.synthetic.main.activity_bet_details.*

class BetDetails : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bet_details)

        //here we call service to get the horses from the request to server
        // for testing i wrote that function
        val horses = initHorsesList()

        horsesBetDetailsList.layoutManager = LinearLayoutManager(this)
        horsesBetDetailsList.setHasFixedSize(true)
        horsesBetDetailsList.adapter = HorseAdapter(horses)

    }

}
