package ru.yesds.yesdsapp.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Teacher(
    val name: String,
    val isLeader: Boolean,
    val profession: String,
    val photo_min: Int,
    val photo_big: Int,
    val description: String,
    val dances_since: String,
    val teaches_since: String
) : Parcelable