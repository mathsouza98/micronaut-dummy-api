package example.micronaut.application.mappers

import example.micronaut.application.models.BookRequest
import example.micronaut.application.models.BookResponse
import example.micronaut.core.models.Book
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy

@Mapper(componentModel = "jsr330", unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface BookMapper {
    fun fromRequest(bookRequest: BookRequest) : Book
    fun toResponse(book: Book): BookResponse
    fun toResponse(books: List<Book>): List<BookResponse>
}