package example.micronaut.repository

import example.micronaut.model.Book
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository
import java.util.*

@Repository
interface BookRepository: CrudRepository<Book, UUID> {
}