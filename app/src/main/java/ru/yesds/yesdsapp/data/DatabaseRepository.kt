package ru.yesds.yesdsapp.data

import ru.yesds.yesdsapp.data.db.UserEntity

interface DatabaseRepository {
    suspend fun saveUser(user: UserEntity)
}