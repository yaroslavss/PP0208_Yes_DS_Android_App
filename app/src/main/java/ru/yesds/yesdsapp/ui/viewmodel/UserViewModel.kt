package ru.yesds.yesdsapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.yesds.yesdsapp.data.AuthApiImpl
import ru.yesds.yesdsapp.data.AuthRepositoryImpl
import ru.yesds.yesdsapp.model.User
import ru.yesds.yesdsapp.util.ApiResponse

class UserViewModel : ViewModel() {
    private val repositoryImpl = AuthRepositoryImpl(AuthApiImpl())
    private val _user = MutableLiveData<User>().apply {
        value = null
    }
    val user: LiveData<User> = _user

    fun signIn(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = repositoryImpl.signIn(user)
            if (response is ApiResponse.Success) {
                response.data?.let { user ->
                    _user.postValue(User(user.username, user.password, user.token))
                }
            }
            if (response is ApiResponse.Error) {
                println("!!! Error: ${response.message}")
            }
        }
    }
}