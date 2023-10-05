package ru.yesds.yesdsapp.data

import ru.yesds.yesdsapp.data.model.CatResponse

interface RemoteApi {
    suspend fun getCat(): CatResponse?
}