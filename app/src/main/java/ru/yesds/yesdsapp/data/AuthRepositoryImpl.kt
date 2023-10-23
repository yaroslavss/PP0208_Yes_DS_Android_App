package ru.yesds.yesdsapp.data

import retrofit2.HttpException
import ru.yesds.yesdsapp.data.mapper.AuthMapper.toUser
import ru.yesds.yesdsapp.model.User
import ru.yesds.yesdsapp.util.ApiResponse
import java.io.IOException

class AuthRepositoryImpl(private val authApi: AuthApi) : AuthRepository {
    override suspend fun signIn(user: User): ApiResponse<User?> {
        return try {
            val response = authApi.signIn(user)
            if (response.isSuccessful()) {
                ApiResponse.Success(response.body()?.toUser())
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