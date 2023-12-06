package ru.yesds.yesdsapp.data

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Url
import ru.yesds.yesdsapp.data.model.AuthResponse
import ru.yesds.yesdsapp.domain.model.User

interface AuthService {
    @Headers("Content-Type: application/json")
    @POST
    suspend fun signIn(
        @Body user: User,
        @Url url: String
   ): Response<AuthResponse>
}