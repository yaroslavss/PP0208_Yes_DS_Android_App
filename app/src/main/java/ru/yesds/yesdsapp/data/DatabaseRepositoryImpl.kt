package ru.yesds.yesdsapp.data

import ru.yesds.yesdsapp.data.db.UserDao
import ru.yesds.yesdsapp.data.db.UserEntity

class DatabaseRepositoryImpl(private val userDao: UserDao) : DatabaseRepository {
    override suspend fun saveUser(user: UserEntity) = userDao.saveUser(user)

    override fun getUser() = userDao.getUser()
}