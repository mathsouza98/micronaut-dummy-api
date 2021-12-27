package example.micronaut

import example.micronaut.model.Book
import example.micronaut.repository.BookRepository
import io.micronaut.http.HttpResponse
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
    fun getBooks(): HttpResponse<List<Book>> {
        val books = bookRepository.findAll().toList()
        books.stream().map{book -> println(book.id)}
        return HttpResponse.ok(books);
    }

    @Post
    fun insertBook(request: BookRequest): HttpResponse<Book> {
        val bookEntity = Book(
            id = UUID.randomUUID().toString(),
            title = request.title,
            pages = request.pages
        )
        val created = bookRepository.save(bookEntity);
        return HttpResponse.created(created);
    }
}