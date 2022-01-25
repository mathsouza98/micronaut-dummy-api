package example.micronaut.application.mappers

import example.micronaut.application.models.AuthorRequest
import example.micronaut.application.models.AuthorResponse
import example.micronaut.core.models.Author
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy

@Mapper(componentModel = "jsr330", unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface AuthorMapper {
    fun fromRequest(authorRequest: AuthorRequest): Author
    fun toResponse(author: Author): AuthorResponse
}