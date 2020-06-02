package com.kirichripper.entertainment.temabet.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kirichripper.entertainment.temabet.R
import com.kirichripper.entertainment.temabet.data.Horse
import kotlinx.android.synthetic.main.list_item_horse.view.*


class HorseAdapter(val horseList : List<Horse>) :
    RecyclerView.Adapter<HorseAdapter.HorseViewHolder>() {


    class HorseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var horseRaceNumber: TextView = itemView.horseNumberText!!
        var horseName: TextView = itemView.horseNameText!!
        var coefficient: TextView = itemView.coefficientText!!
        var winRate : TextView = itemView.horseWinRateText!!
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HorseViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.list_item_horse,parent,false)
        return HorseViewHolder(view)
    }


    override fun onBindViewHolder(holder: HorseViewHolder, position: Int) {
        val currentHorse = horseList[position]

        holder.horseRaceNumber.text = "#${(position + 1)}"
        holder.horseName.text = currentHorse.name
        holder.winRate.text = "${currentHorse.winRate}%"
        holder.coefficient.text = "${currentHorse.coefficient}x"
    }


    override fun getItemCount(): Int {
        return horseList.size
    }
}