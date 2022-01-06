package example.micronaut.infrastructure

import example.micronaut.core.models.Book
import example.micronaut.core.ports.outcoming.BookDatabase
import jakarta.inject.Inject
import jakarta.inject.Singleton
import java.util.*

@Singleton
class BookDatabaseAdapter @Inject constructor(
    private val bookRepository: BookRepository
) : BookDatabase {

    override fun save(book: Book): Book {
        return bookRepository.save(book)
    }

    override fun getBook(id: String): Optional<Book> {
        return bookRepository.findById(id)
    }

    override fun getAllBooks(): List<Book> {
        return bookRepository.findAll().toList()
    }
}