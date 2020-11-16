package dev.swetha.bookdetails.data.remote.api

import dev.swetha.bookdetails.model.BooksResponse
import retrofit2.Response
import retrofit2.http.GET

interface BooksService {

    @GET("/books/v1/volumes?q=health&maxResults=20")
    suspend fun getPosts(): Response<BooksResponse>

    companion object {
        const val BOOK_API_URL = "https://www.googleapis.com/"
    }
}
