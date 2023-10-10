package ru.yesds.yesdsapp.data.mapper

import ru.yesds.yesdsapp.data.model.AuthResponse
import ru.yesds.yesdsapp.model.User

object AuthMapper {
    fun AuthResponse.toUser() = User(
        username = this.username,
        password = "",
        token = this.token
    )
}