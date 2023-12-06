package ru.yesds.yesdsapp.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.yesds.yesdsapp.di.modules.DatabaseModule
import ru.yesds.yesdsapp.di.modules.RemoteModule
import ru.yesds.yesdsapp.ui.viewmodel.UserViewModel
import javax.inject.Singleton

@Singleton
@Component(
    // all modules
    modules = [
        RemoteModule::class,
        DatabaseModule::class
    ]
)
interface AppComponent {
    @Component.Factory
    interface Factory{
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun inject(userViewModel: UserViewModel)
}