package example.micronaut.application.models

import javax.validation.constraints.NotNull

data class AuthorRequest (
    val name: @NotNull String
)