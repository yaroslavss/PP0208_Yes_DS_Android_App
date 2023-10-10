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

class ProfileViewModel : ViewModel() {
    private val repositoryImpl = AuthRepositoryImpl(AuthApiImpl())
    private val _token = MutableLiveData<String>().apply {
        value = "Token is not set now"
    }
    val token: LiveData<String> = _token

    fun signIn(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = repositoryImpl.signIn(user)
            if (response is ApiResponse.Success) {
                _token.postValue(response.data?.token)
            }
            if (response is ApiResponse.Error) {
                println("!!! Error: ${response.message}")
            }
        }
    }

}