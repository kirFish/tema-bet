package com.kirichripper.entertainment.temabet.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kirichripper.entertainment.temabet.R
import com.kirichripper.entertainment.temabet.data.Horse
import kotlinx.android.synthetic.main.horses_list_item.view.*


class HorseAdapter(val horseList : List<Horse>) :
    RecyclerView.Adapter<HorseAdapter.BetDetailsViewHolder>() {


    class BetDetailsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var horseRaceNumber: TextView = itemView.horseNumberText!!
        var horseName: TextView = itemView.horseNameText!!
        var coefficient: TextView = itemView.coefficientText!!
        var winRate : TextView = itemView.horseWinRateText!!
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BetDetailsViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.horses_list_item,parent,false)
        return BetDetailsViewHolder(view)
    }

    override fun onBindViewHolder(holder: BetDetailsViewHolder, position: Int) {
        val currentHorse = horseList[position]

        holder.horseRaceNumber.text = "#" + (position+1).toString()
        holder.horseName.text = currentHorse.name
        holder.winRate.text = currentHorse.winRate.toString() + "%"
        holder.coefficient.text = currentHorse.coefficient.toString()
    }

    override fun getItemCount(): Int {
        return horseList.size
    }
}