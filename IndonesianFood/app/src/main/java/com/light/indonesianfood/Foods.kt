package com.light.indonesianfood

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Foods(
    var name: String? = "",
    var detail: String? ="",
    var photo: Int? = 0
//    var images: String?
): Parcelable

