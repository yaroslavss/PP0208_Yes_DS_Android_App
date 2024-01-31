package ru.yesds.yesdsapp.data.model

import com.google.gson.annotations.SerializedName

data class TeacherResponse(
    @SerializedName("idUser")
    val idUser: Int,
    @SerializedName("userName")
    val userName: String,
    @SerializedName("userPhoto")
    val userPhoto: String,
    @SerializedName("dateOfBirth")
    val dateOfBirth: String,
    @SerializedName("postUser")
    val postUser: String,
    @SerializedName("telegramLink")
    val telegramLink: String,
    @SerializedName("vkLink")
    val vkLink: String,
    @SerializedName("instagramLink")
    val instagramLink: String,
    @SerializedName("identifier")
    val identifier: String,
    @SerializedName("accountID")
    val accountID: Int
)