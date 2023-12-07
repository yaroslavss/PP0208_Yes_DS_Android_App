package ru.yesds.yesdsapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException
import ru.yesds.yesdsapp.App
import ru.yesds.yesdsapp.data.mapper.AuthMapper.toUserEntity
import ru.yesds.yesdsapp.data.repository.AuthRepositoryImpl
import ru.yesds.yesdsapp.data.repository.DatabaseRepositoryImpl
import ru.yesds.yesdsapp.domain.model.User
import ru.yesds.yesdsapp.util.ApiResponse
import java.io.IOException
import javax.inject.Inject

class UserViewModel : ViewModel() {

    @Inject
    lateinit var databaseRepositoryImpl: DatabaseRepositoryImpl

    @Inject
    lateinit var remoteRepositoryImpl: AuthRepositoryImpl

    init {
        App.instance.dagger.inject(this)
    }

    fun signIn(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            val result = try {
                val response = remoteRepositoryImpl.signIn(user)
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

            if (result is ApiResponse.Success) {
                result.data.let { authResponse ->
                    databaseRepositoryImpl.saveUser(authResponse.toUserEntity())
                }
            }
            if (result is ApiResponse.Error) {
                println("!!! Error: ${result.message}")
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