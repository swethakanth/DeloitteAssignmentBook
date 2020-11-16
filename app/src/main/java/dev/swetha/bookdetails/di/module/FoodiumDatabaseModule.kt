package dev.swetha.bookdetails.di.module

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dev.swetha.bookdetails.data.local.BookPostsDatabase
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
class FoodiumDatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(application: Application) = BookPostsDatabase.getInstance(application)

    @Singleton
    @Provides
    fun providePostsDao(database: BookPostsDatabase) = database.getPostsDao()
}
