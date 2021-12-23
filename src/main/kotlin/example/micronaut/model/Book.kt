package example.micronaut.model

import java.util.*
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Book (
    @Id
    val id: UUID?,
    val title: String,
    val pages: Int
)