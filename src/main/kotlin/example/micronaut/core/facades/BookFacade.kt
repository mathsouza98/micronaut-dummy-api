package example.micronaut.core.facades

import example.micronaut.core.models.Book
import example.micronaut.core.ports.incoming.AddNewBook
import example.micronaut.core.ports.outcoming.BookDatabase
import jakarta.inject.Inject
import jakarta.inject.Singleton

@Singleton
class BookFacade @Inject constructor(
    private val bookDatabaseAdapter: BookDatabase
) : AddNewBook {
    override fun handle(book: Book): Book {
        return bookDatabaseAdapter.save(book)
    }
}