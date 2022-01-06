package example.micronaut.application.models

import example.micronaut.core.models.Author
import javax.validation.constraints.NotNull

data class BookResponse (
    val id: String,
    val title: @NotNull String,
    val pages: @NotNull Int,
    val author: @NotNull Author
)
