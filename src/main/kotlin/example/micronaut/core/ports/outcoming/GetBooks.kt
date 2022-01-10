package example.micronaut.core.ports.outcoming

import example.micronaut.core.models.Book

interface GetBooks {
    fun handle(): List<Book>
}