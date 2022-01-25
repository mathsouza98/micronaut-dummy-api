package example.micronaut.core.ports.outcoming

import example.micronaut.core.models.Author
import java.util.*

interface AuthorDatabase {
    fun save(author: Author): Author
    fun findAuthorByName(name: String): Optional<Author>
}