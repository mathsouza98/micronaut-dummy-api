package example.micronaut.repository

import example.micronaut.model.Book
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository

@Repository
interface BookRepository: CrudRepository<Book, String> {
}