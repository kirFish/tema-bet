package com.kirichripper.entertainment.temabet.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kirichripper.entertainment.temabet.R
import com.kirichripper.entertainment.temabet.data.Bet
import kotlinx.android.synthetic.main.list_item_bet.view.*

class BetAdapter(private val betList: List<Bet>) : RecyclerView.Adapter<BetAdapter.HistoryViewHolder>(){


    class HistoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var raceId = itemView.raceIdText!!
        var winnerName = itemView.winnerText!!
        var place = itemView.historyPlace!!
        var time = itemView.historyDateAndTimeLabel!!
        var moneyDifference = itemView.moneyChangeText!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_bet,parent, false)
        return HistoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {

        val currentBet = betList[position]

        holder.raceId.text = currentBet.run?.id.toString()
        holder.place.text = currentBet.run?.place
        holder.time.text  = currentBet.run?.date

        // TODO figure out the way to store userId and compare with the winnerId
        val userId = 1;

        val userIsWinner = userId == currentBet.winnerId
        val winner: String
        val moneyChange: String

        if(userIsWinner){
            winner = getWinnerNameById(userId)
            moneyChange = (currentBet.amount * currentBet.moneyMultiplier).toString()
        }else{
            winner = getWinnerNameById(currentBet.winnerId)
            moneyChange = (-1* currentBet.amount * currentBet.moneyMultiplier).toString()
        }

        holder.winnerName.text =  winner
        holder.moneyDifference.text = moneyChange

    }

    override fun getItemCount(): Int {
        return betList.size
    }

    private fun getWinnerNameById(winnerId: Int?): String {
        //TODO
        // match if winnerId == userId and if no ask server to get name by id
        return "Tema2"
    }
}