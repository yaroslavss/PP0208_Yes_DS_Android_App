package ru.yesds.yesdsapp.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveUser(userEntity: UserEntity)

    @Query("SELECT * FROM users")
    fun getUser(): Flow<UserEntity>

    @Query("DELETE FROM users")
    suspend fun deleteAll()
}