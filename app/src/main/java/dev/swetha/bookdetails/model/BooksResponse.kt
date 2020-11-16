package dev.swetha.bookdetails.model

import java.lang.StringBuilder

class BooksResponse {

    var items: List<Book>? = null

    fun convertToPost(): List<Post> {

        return items?.map { book ->

            Post(
                id = book.id?:"",
                title = book.volumeInfo?.title,
                subtitle = book.volumeInfo?.subtitle,
                thumbnail = book.volumeInfo?.imageLinks?.thumbnail,
                smallThumbnail = book.volumeInfo?.imageLinks?.smallThumbnail,
                authors = book.volumeInfo?.authors?.commaseperate(),
                publisher = book.volumeInfo?.publisher,
                publishedDate = book.volumeInfo?.publishedDate,
                description = book.volumeInfo?.description,
                categories = book.volumeInfo?.categories?.commaseperate(),
                country = book.saleInfo?.country,
                saleability = book.saleInfo?.saleability,
                buyLink = book.selfLink,
                imageUrl = book.volumeInfo?.imageLinks?.thumbnail
            )
        }?.toList() ?: emptyList()

    }


}

private fun <E> List<E>.commaseperate(): String? {

    val stringBuilder = StringBuilder()
    if (size > 0) {
        forEach {
            stringBuilder.append(it).append(",")
        }
        stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(","))
    }
    return stringBuilder.toString()
}
