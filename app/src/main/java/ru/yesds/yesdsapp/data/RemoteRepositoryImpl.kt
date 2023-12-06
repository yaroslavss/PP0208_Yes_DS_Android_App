package ru.yesds.yesdsapp.data

import retrofit2.HttpException
import ru.yesds.yesdsapp.data.mapper.CatMapper.toCat
import ru.yesds.yesdsapp.domain.model.Cat
import ru.yesds.yesdsapp.util.ApiResponse
import java.io.IOException

class RemoteRepositoryImpl(private val remoteApi: RemoteApi) : RemoteRepository {
    override suspend fun getCat(): ApiResponse<Cat?> {
        return try {
            val response = remoteApi.getCat()
            if (response.isSuccessful()) {
                ApiResponse.Success(response.body()?.toCat())
            } else {
                ApiResponse.Error(response.message())
            }
        } catch (e: HttpException) {
            // request exception
            ApiResponse.Error(e.toString())
        } catch (e: IOException) {
            // no internet exception
            ApiResponse.Error(e.toString())
        }
    }
}