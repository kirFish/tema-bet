package com.kirichripper.entertainment.temabet.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ServiceInitMsg(
    val address: String,

    val login: String,

    val password: String
) : Parcelable