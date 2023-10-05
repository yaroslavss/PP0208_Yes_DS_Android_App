package ru.yesds.yesdsapp.data

import ru.yesds.yesdsapp.model.Cat

interface RemoteRepository {
    suspend fun getCat(): Cat
}