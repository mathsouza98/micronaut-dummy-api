package example.micronaut.infrastructure

import example.micronaut.core.models.Author
import example.micronaut.core.ports.outcoming.AuthorDatabase
import jakarta.inject.Singleton
import java.util.*

@Singleton
class AuthorDatabaseAdapter constructor(
    private val authorRepository: AuthorRepository
): AuthorDatabase {

    override fun save(author: Author): Author {
        return authorRepository.save(author)
    }

    override fun findAuthorByName(name: String): Optional<Author> {
        return authorRepository.findByName(name)
    }

}