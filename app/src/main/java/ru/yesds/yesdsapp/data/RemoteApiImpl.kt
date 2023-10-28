package ru.yesds.yesdsapp.data

import retrofit2.Response
import ru.yesds.yesdsapp.data.model.CatResponse

class RemoteApiImpl : RemoteApi {
    override suspend fun getCat(): Response<CatResponse> {
        return RetrofitInstance.catApi.getCat()
    }
}