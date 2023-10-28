package ru.yesds.yesdsapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.yesds.yesdsapp.data.RemoteApiImpl
import ru.yesds.yesdsapp.data.RemoteRepositoryImpl
import ru.yesds.yesdsapp.util.ApiResponse

class MainPageViewModel : ViewModel() {
    private val repositoryImpl = RemoteRepositoryImpl(RemoteApiImpl())
    private val _image = MutableLiveData<String>().apply {
        value = "Image is not set now"
    }
    val image: LiveData<String> = _image

    init {
        getCat()
    }

    private fun getCat() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = repositoryImpl.getCat()
            if (response is ApiResponse.Success) {
                _image.postValue(response.data?.image)
            }
            if (response is ApiResponse.Error) {
                println("!!! Error: ${response.message}")
            }
        }
    }
}