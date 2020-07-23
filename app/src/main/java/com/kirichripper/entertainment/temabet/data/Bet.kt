package com.kirichripper.entertainment.temabet.data

data class Bet(val id: Int,
               val who: String,
               val amount: Int,
               val winnerId: Int?,
               val moneyMultiplier: Double,
               // run on which the bet was placed
               val run: Run?
               //for the future
               //not yet in the API
               //val currency: Byte?
               )