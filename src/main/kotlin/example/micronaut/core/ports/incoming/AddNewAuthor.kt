package example.micronaut.core.ports.incoming

import example.micronaut.core.models.Author

interface AddNewAuthor {
    fun handle(author: Author): Author
}