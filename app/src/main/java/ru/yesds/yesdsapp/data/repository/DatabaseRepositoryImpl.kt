package ru.yesds.yesdsapp.data.repository

import ru.yesds.yesdsapp.data.db.UserDao
import ru.yesds.yesdsapp.data.db.UserEntity
import ru.yesds.yesdsapp.domain.repository.DatabaseRepository

class DatabaseRepositoryImpl(private val userDao: UserDao) : DatabaseRepository {
    override suspend fun saveUser(user: UserEntity) = userDao.saveUser(user)

    override fun getUser() = userDao.getUser()

    override suspend fun deleteAllUsers() = userDao.deleteAll()
}