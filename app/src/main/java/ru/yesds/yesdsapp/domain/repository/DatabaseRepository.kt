package ru.yesds.yesdsapp.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.yesds.yesdsapp.data.db.UserEntity

interface DatabaseRepository {
    suspend fun saveUser(user: UserEntity)

    fun getUser(): Flow<UserEntity>

    suspend fun deleteAllUsers()
}