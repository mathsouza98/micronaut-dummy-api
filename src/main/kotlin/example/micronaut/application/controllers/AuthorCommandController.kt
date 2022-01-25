package example.micronaut.application.controllers;

import example.micronaut.application.mappers.AuthorMapper
import example.micronaut.application.models.AuthorRequest
import example.micronaut.application.models.AuthorResponse
import example.micronaut.core.ports.incoming.AddNewAuthor
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;

import io.micronaut.http.annotation.Post;
import jakarta.inject.Inject

@Controller("/author")
class AuthorCommandController @Inject constructor(
    private val authorMapper: AuthorMapper,
    private val addNewAuthor: AddNewAuthor
) {
    @Post
    fun insertAuthor(authorRequest: AuthorRequest): HttpResponse<AuthorResponse> {
        val author = authorMapper.fromRequest(authorRequest)
        val created = addNewAuthor.handle(author)
        val response = authorMapper.toResponse(created)
        return HttpResponse.created(response)
    }
}
