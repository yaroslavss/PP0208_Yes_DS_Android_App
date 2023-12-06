package ru.yesds.yesdsapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.yesds.yesdsapp.App
import ru.yesds.yesdsapp.data.AuthApiImpl
import ru.yesds.yesdsapp.data.AuthRepositoryImpl
import ru.yesds.yesdsapp.data.DatabaseRepositoryImpl
import ru.yesds.yesdsapp.data.mapper.AuthMapper.toUserEntity
import ru.yesds.yesdsapp.domain.model.User
import ru.yesds.yesdsapp.util.ApiResponse
import javax.inject.Inject

class UserViewModel : ViewModel() {
    private val repositoryImpl = AuthRepositoryImpl(AuthApiImpl())

    @Inject
    lateinit var databaseRepositoryImpl: DatabaseRepositoryImpl

    init {
        App.instance.dagger.inject(this)
    }

    fun signIn(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = repositoryImpl.signIn(user)
            if (response is ApiResponse.Success) {
                response.data.let { authResponse ->
                    databaseRepositoryImpl.saveUser(authResponse.toUserEntity())
                }
            }
            if (response is ApiResponse.Error) {
                println("!!! Error: ${response.message}")
            }
        }
    }

    fun getUserFromDB() = databaseRepositoryImpl.getUser()

    fun signOut() {
        viewModelScope.launch(Dispatchers.IO) {
            databaseRepositoryImpl.deleteAllUsers()
        }
    }
}