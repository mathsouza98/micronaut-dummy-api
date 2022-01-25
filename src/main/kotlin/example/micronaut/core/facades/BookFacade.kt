package example.micronaut.core.facades

import example.micronaut.core.models.Book
import example.micronaut.core.models.exceptions.AuthorNotFoundException
import example.micronaut.core.ports.incoming.AddNewBook
import example.micronaut.core.ports.outcoming.BookDatabase
import example.micronaut.core.ports.outcoming.GetBooks
import example.micronaut.infrastructure.AuthorDatabaseAdapter
import io.micronaut.cache.annotation.CacheConfig
import io.micronaut.cache.annotation.Cacheable
import jakarta.inject.Inject
import jakarta.inject.Singleton

@Singleton
@CacheConfig("book")
open class BookFacade @Inject constructor(
    private val bookDatabaseAdapter: BookDatabase,
    private val authorDatabaseAdapter: AuthorDatabaseAdapter
) : AddNewBook, GetBooks {
    override fun handle(book: Book): Book {
        val author = authorDatabaseAdapter.findAuthorByName(book.author.name)

        if (author.isEmpty) throw AuthorNotFoundException()

        book.author = author.get()
        return bookDatabaseAdapter.save(book)
    }

    @Cacheable
    override fun handle(): List<Book> {
        return bookDatabaseAdapter.getAllBooks()
    }
}
