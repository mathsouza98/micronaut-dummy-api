package example.micronaut.core.facades

import example.micronaut.core.models.Author
import example.micronaut.core.ports.incoming.AddNewAuthor
import example.micronaut.infrastructure.AuthorDatabaseAdapter
import jakarta.inject.Singleton

@Singleton
class AuthorFacade constructor(
    private val authorDatabaseAdapter: AuthorDatabaseAdapter
): AddNewAuthor {

    override fun handle(author: Author): Author {
        val optionalAuthor = authorDatabaseAdapter.findAuthorByName(author.name)

        if (optionalAuthor.isEmpty) return authorDatabaseAdapter.save(author)

        return author
    }
}