package com.kirichripper.entertainment.temabet.data

data class Bet(val id: Int?,
               val who: String,
               val value: Int?,
               val runId: Int?,
               val winnerId: Int?,
               val moneyMultiplier: Double
               //for the future
               //not yet in the API
               //val currency: Byte?
               )