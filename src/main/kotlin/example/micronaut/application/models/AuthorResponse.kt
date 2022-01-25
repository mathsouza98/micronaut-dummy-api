package example.micronaut.application.models

import javax.validation.constraints.NotNull

data class AuthorResponse (
    val id: String,
    val name: @NotNull String
)