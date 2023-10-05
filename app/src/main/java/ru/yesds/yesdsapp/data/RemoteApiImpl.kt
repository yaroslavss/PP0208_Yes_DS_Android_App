package ru.yesds.yesdsapp.data

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.yesds.yesdsapp.data.Constants.BASE_URL
import ru.yesds.yesdsapp.data.model.CatResponse

class RemoteApiImpl : RemoteApi {
    private val logging = HttpLoggingInterceptor()
        .setLevel(HttpLoggingInterceptor.Level.BODY)
    private val client = OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()
    private val remoteService = retrofit.create(CatService::class.java)

    override suspend fun getCat(): CatResponse? {
        return remoteService.getCat().body()
    }
}