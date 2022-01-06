package example.micronaut.infrastructure

import example.micronaut.core.models.Book
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository
import java.util.*

@Repository
interface BookRepository: CrudRepository<Book, String> {
}