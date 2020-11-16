package dev.swetha.bookdetails.di.module

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dev.swetha.bookdetails.data.remote.api.BooksService
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
class FoodiumApiModule {

    @Singleton
    @Provides
    fun provideRetrofitService(): BooksService = Retrofit.Builder()
        .baseUrl(BooksService.BOOK_API_URL)
        .addConverterFactory(
            MoshiConverterFactory.create(
                Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
            )
        )
        .build()
        .create(BooksService::class.java)
}
