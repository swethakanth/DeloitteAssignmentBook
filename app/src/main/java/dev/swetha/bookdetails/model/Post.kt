package dev.swetha.bookdetails.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import dev.swetha.bookdetails.model.Post.Companion.TABLE_NAME
import java.util.*

@Entity(tableName = TABLE_NAME)
data class Post(

    @PrimaryKey
    var id: String = UUID.randomUUID().toString(),
    var title: String? = null,
    var subtitle: String? = null,
    var smallThumbnail: String? = null,
    var thumbnail: String? = null,
    var authors: String? = null,
    var publisher: String? = null,
    var publishedDate: String? = null,
    var description: String? = null,
    var categories: String? = null,
    var country: String? = null,
    var saleability: String? = null,
    var buyLink: String? = null,
    var author: String? = null,
    var body: String? = null,
    var imageUrl: String? = null
) {
    companion object {
        const val TABLE_NAME = "foodium_posts"
    }
}

/*
* title, subtitle, thumbnail, authors, publisher, publishedDate, description and categories) and saleInfo (country, saleability, listPrice, retailPrice, buyLink and offers) details.

*
*
* */
