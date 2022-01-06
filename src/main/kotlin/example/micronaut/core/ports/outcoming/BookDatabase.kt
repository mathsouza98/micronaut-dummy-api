package example.micronaut.core.ports.outcoming

import example.micronaut.core.models.Book
import java.util.*

interface BookDatabase {
    fun save(book: Book): Book
    fun getBook(id: String): Optional<Book>
    fun getAllBooks(): List<Book>
}