package com.kirichripper.entertainment.temabet.data

data class Run (val id: Int,
                val date: String,
                val place: String,
                val competitorsList: List<Horse>)