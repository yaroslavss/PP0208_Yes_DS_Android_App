package ru.yesds.yesdsapp.data.repository

import retrofit2.Response
import ru.yesds.yesdsapp.data.api.AuthService
import ru.yesds.yesdsapp.data.model.AuthResponse
import ru.yesds.yesdsapp.domain.model.User
import ru.yesds.yesdsapp.domain.repository.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(private val remoteService: AuthService) :
    AuthRepository {

    override suspend fun signIn(user: User): Response<AuthResponse> {
        return remoteService.signIn(user)
    }
}