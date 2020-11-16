package dev.swetha.bookdetails.data.repository

import androidx.annotation.MainThread
import dev.swetha.bookdetails.data.local.dao.PostsDao
import dev.swetha.bookdetails.data.remote.api.BooksService
import dev.swetha.bookdetails.model.BooksResponse
import dev.swetha.bookdetails.model.Post
import dev.swetha.bookdetails.model.State
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Singleton repository for fetching data from remote and storing it in database
 * for offline capability. This is Single source of data.
 */
@ExperimentalCoroutinesApi
@Singleton
class PostsRepository @Inject constructor(
    private val postsDao: PostsDao,
    private val booksService: BooksService
) {

    /**
     * Fetched the posts from network and stored it in database. At the end, data from persistence
     * storage is fetched and emitted.
     */
    fun getAllPosts(): Flow<State<List<Post>>> {
        return object : NetworkBoundRepository<List<Post>, BooksResponse>() {

            override suspend fun saveRemoteData(response: BooksResponse) =
                postsDao.insertPosts(response.convertToPost())

            override fun fetchFromLocal(): Flow<List<Post>> = postsDao.getAllPosts()

            override suspend fun fetchFromRemote(): Response<BooksResponse> = booksService.getPosts()
        }.asFlow()
    }

    /**
     * Retrieves a post with specified [postId].
     * @param postId Unique id of a [Post].
     * @return [Post] data fetched from the database.
     */
    @MainThread
    fun getPostById(postId: String): Flow<Post> = postsDao.getPostById(postId)
}
