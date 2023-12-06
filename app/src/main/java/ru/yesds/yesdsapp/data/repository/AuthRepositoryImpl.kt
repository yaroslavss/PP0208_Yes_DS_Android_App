package ru.yesds.yesdsapp.data.repository

import retrofit2.HttpException
import ru.yesds.yesdsapp.data.AuthApi
import ru.yesds.yesdsapp.data.model.AuthResponse
import ru.yesds.yesdsapp.domain.model.User
import ru.yesds.yesdsapp.domain.repository.AuthRepository
import ru.yesds.yesdsapp.util.ApiResponse
import java.io.IOException

class AuthRepositoryImpl(private val authApi: AuthApi) : AuthRepository {
    override suspend fun signIn(user: User): ApiResponse<AuthResponse> {
        return try {
            val response = authApi.signIn(user)
            if (response.isSuccessful()) {
                ApiResponse.Success(response.body()!!)
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