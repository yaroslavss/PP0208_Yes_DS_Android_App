package ru.yesds.yesdsapp.domain.repository

import ru.yesds.yesdsapp.domain.model.Cat
import ru.yesds.yesdsapp.util.ApiResponse

interface RemoteRepository {
    suspend fun getCat(): ApiResponse<Cat?>
}