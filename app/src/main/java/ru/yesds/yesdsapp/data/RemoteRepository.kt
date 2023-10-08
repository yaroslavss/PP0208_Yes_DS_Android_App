package ru.yesds.yesdsapp.data

import ru.yesds.yesdsapp.model.Cat
import ru.yesds.yesdsapp.util.ApiResponse

interface RemoteRepository {
    suspend fun getCat(): ApiResponse<Cat?>
}