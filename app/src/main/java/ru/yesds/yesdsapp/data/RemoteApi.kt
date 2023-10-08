package ru.yesds.yesdsapp.data

import retrofit2.Response
import ru.yesds.yesdsapp.data.model.CatResponse

interface RemoteApi {
    suspend fun getCat(): Response<CatResponse>
}