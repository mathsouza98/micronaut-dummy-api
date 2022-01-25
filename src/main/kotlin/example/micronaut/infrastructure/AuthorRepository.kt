package example.micronaut.infrastructure

import example.micronaut.core.models.Author
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository
import java.util.*

@Repository
interface AuthorRepository: CrudRepository<Author, String> {
    fun findByName(name: String): Optional<Author>
}