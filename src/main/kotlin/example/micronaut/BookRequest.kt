package example.micronaut

import javax.validation.Valid
import javax.validation.constraints.NotNull

data class BookRequest (
    val title: @Valid @NotNull String,
    val pages: @NotNull Int
)
