package com.light.mynotesapp

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Note(
    var id: Int = 0,
    var title: String = "",
    var description: String = "",
    var date: String = ""
): Parcelable
