package ru.yesds.yesdsapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import ru.yesds.yesdsapp.data.RemoteApiImpl
import ru.yesds.yesdsapp.data.RemoteRepositoryImpl
import ru.yesds.yesdsapp.model.Cat

class MainPageFragmentViewModel : ViewModel() {
    private val repositoryImpl = RemoteRepositoryImpl(RemoteApiImpl())

    suspend fun getCat(): Cat = repositoryImpl.getCat()
}