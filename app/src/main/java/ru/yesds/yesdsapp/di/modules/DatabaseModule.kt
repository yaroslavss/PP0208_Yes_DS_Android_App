package ru.yesds.yesdsapp.di.modules

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import ru.yesds.yesdsapp.data.DatabaseRepositoryImpl
import ru.yesds.yesdsapp.data.db.AppDatabase
import ru.yesds.yesdsapp.data.db.UserDao
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Provides
    @Singleton
    fun provideUserDao(context: Context) =
        Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "studio_db"
        ).build().userDao()

    @Provides
    @Singleton
    fun provideRepository(userDao: UserDao) = DatabaseRepositoryImpl(userDao)
}