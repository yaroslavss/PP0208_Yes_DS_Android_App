package ru.yesds.yesdsapp.data

import ru.yesds.yesdsapp.model.User
import ru.yesds.yesdsapp.util.ApiResponse

interface AuthRepository {
    suspend fun signIn(user: User): ApiResponse<User?>
}