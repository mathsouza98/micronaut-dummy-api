package example.micronaut.core.ports.incoming

import example.micronaut.core.models.Book

interface AddNewBook {
    fun handle(book: Book): Book
}