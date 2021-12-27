package example.micronaut.model

import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Book (
    @Id
    val id: String?,
    val title: String,
    val pages: Int
)