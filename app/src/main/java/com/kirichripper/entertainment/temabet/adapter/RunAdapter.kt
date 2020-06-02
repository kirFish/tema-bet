package com.kirichripper.entertainment.temabet.adapter

import android.content.Context
import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kirichripper.entertainment.temabet.R
import com.kirichripper.entertainment.temabet.data.Run
import kotlinx.android.synthetic.main.runs_list_item.view.*

class RunAdapter(private val RunsList: List<Run> , private val context: Context)  : RecyclerView.Adapter<RunAdapter.RunViewHolder>() {


    class RunViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var dateAndTimeText = itemView.dateAndTimeText!!
        var placeText = itemView.placeText!!
        var raceNumberText = itemView.raceNumberText!!
        var horsesList = itemView.horsesRunList!!
    }

    override fun onBindViewHolder(holder: RunViewHolder, position: Int) {
        val currentRun = RunsList[position]

        holder.dateAndTimeText.text = currentRun.date
        holder.placeText.text = currentRun.place
        holder.raceNumberText.text = "#" + currentRun.id.toString()

        holder.horsesList.adapter = HorseAdapter(currentRun.horsesList)
        holder.horsesList.setHasFixedSize(true)
        holder.horsesList.layoutManager = LinearLayoutManager(context)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RunViewHolder {
        val view:View = LayoutInflater.from(parent.context).inflate(R.layout.runs_list_item,parent,false)
        return RunViewHolder(view)
    }

    override fun getItemCount(): Int {
        return RunsList.size
    }
}