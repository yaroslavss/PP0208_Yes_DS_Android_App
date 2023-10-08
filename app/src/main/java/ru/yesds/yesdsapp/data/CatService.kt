package ru.yesds.yesdsapp.data

import retrofit2.Response
import retrofit2.http.GET
import ru.yesds.yesdsapp.data.model.CatResponse

interface CatService {
    @GET("v1/images/search")
    suspend fun getCat(): Response<CatResponse>
}