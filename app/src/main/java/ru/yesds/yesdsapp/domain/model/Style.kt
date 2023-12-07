package ru.yesds.yesdsapp.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Style(
    val name: String,
    val image: Int,
    val description: String
) : Parcelable
