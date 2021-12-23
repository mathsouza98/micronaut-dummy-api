package example.micronaut

import example.micronaut.model.Book
import example.micronaut.repository.BookRepository
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import jakarta.inject.Inject
import java.util.*

@Controller("/book")
class BookController {
    @Inject
    lateinit var bookRepository: BookRepository

    @Get
    fun getBooks(): MutableIterable<Book> {
        return bookRepository.findAll();
    }

    @Post
    fun insertBook(request: BookRequest): Book {
        val bookEntity = Book(
            id = UUID.randomUUID(),
            title = request.title,
            pages = request.pages
        )
        return bookRepository.save(bookEntity);
    }
}