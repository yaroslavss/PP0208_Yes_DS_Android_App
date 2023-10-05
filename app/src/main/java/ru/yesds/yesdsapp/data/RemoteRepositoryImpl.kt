package ru.yesds.yesdsapp.data

import ru.yesds.yesdsapp.data.mapper.CatMapper.toCat
import ru.yesds.yesdsapp.model.Cat

class RemoteRepositoryImpl(private val remoteApi: RemoteApi) : RemoteRepository {
    override suspend fun getCat(): Cat {
        return remoteApi.getCat()!!.toCat()
    }
}