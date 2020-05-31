package com.kirichripper.entertainment.temabet.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.kirichripper.entertainment.temabet.R
import com.kirichripper.entertainment.temabet.adapter.BetDetailsAdapter
import com.kirichripper.entertainment.temabet.data.Horse
import kotlinx.android.synthetic.main.activity_bet_details.*

class BetDetails : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bet_details)

        //here we call service to get the horses from the request to server
        // for testing i wrote that function
        val horses = initHorsesList()

        horsesList.layoutManager = LinearLayoutManager(this)
        horsesList.setHasFixedSize(true)
        horsesList.adapter = BetDetailsAdapter(horses)

    }

    //method for testing
    fun initHorsesList(): List<Horse>{
        val horse1 = Horse(1,"John","Tema",12, 0.5,1.2,1213)
        val horse2 = Horse(2,"John Wick","Tema2",13, 0.56,1.2,2343)
        val horse3 = Horse(3,"Mark","Tema3",12, 0.8,1.05,2223)
        val horse4 = Horse(4,"Houston","Tema4",13, 0.2,1.5,233)
        val horse5 = Horse(5,"Tema","Tema",12, 0.5,1.2,1213)
        val horse6 = Horse(6,"Tema2","Tema2",13, 0.56,1.2,2343)
        val horse7 = Horse(7,"Tema3","Tema3",12, 0.8,1.05,2223)
        val horse8 = Horse(8,"Tema3210","Tema4",13, 0.2,1.5,233)

        return listOf(horse1,horse2,horse3,horse4,horse5,horse6,horse7,horse8)
    }
}
