package example.micronaut.application.controllers

import example.micronaut.application.mappers.BookMapper
import example.micronaut.application.models.BookRequest
import example.micronaut.application.models.BookResponse
import example.micronaut.core.ports.incoming.AddNewBook
import example.micronaut.core.ports.outcoming.GetBooks
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
    private val addNewBook: AddNewBook,
    private val getBooks: GetBooks
){

    @Get
    fun getBooks(): HttpResponse<List<BookResponse>> {
        val books = getBooks.handle()
        val response = bookMapper.toResponse(books)
        return HttpResponse.ok(response);
    }

    @Post
    fun insertBook(@Body @Valid request: BookRequest): HttpResponse<BookResponse> {
        val book = bookMapper.fromRequest(request)
        val created = addNewBook.handle(book)
        val response = bookMapper.toResponse(created)
        return HttpResponse.created(response);
    }
}