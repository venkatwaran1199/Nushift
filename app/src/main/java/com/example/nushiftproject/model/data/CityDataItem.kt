package com.example.nushiftproject.model.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CityDataItem(
    val lat: String,
    val lon: String,
    val name: String,
    val state: String
):Parcelable