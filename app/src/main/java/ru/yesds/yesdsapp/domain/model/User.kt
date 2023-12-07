package ru.yesds.yesdsapp.domain.model

data class User(
    val username: String,
    val password: String,
    val token: String
)
