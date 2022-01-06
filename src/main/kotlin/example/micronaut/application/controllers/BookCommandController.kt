package example.micronaut.application.controllers

import example.micronaut.application.mappers.BookMapper
import example.micronaut.application.models.BookRequest
import example.micronaut.application.models.BookResponse
import example.micronaut.core.facades.BookFacade
import example.micronaut.core.models.Book
import example.micronaut.core.ports.incoming.AddNewBook
import example.micronaut.infrastructure.BookRepository
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import jakarta.inject.Inject
import javax.validation.Valid

@Controller("/book")
class BookCommandController @Inject constructor(
    private val bookMapper: BookMapper,
    private val bookRepository: BookRepository,
    private val addNewBook: AddNewBook
){

    @Get
    fun getBooks(): HttpResponse<List<Book>> {
        val books = bookRepository.findAll().toList()
        return HttpResponse.ok(books);
    }

    @Post
    fun insertBook(@Body @Valid request: BookRequest): HttpResponse<BookResponse> {
        val book = bookMapper.fromRequest(request)
        val created = addNewBook.handle(book)
        val response = bookMapper.toResponse(created)
        return HttpResponse.created(response);
    }
}