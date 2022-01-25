package example.micronaut.core.models.exceptions

class AuthorNotFoundException(message: String? = "There is no author") : RuntimeException(message) {
}