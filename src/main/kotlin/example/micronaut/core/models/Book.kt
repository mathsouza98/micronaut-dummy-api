package example.micronaut.core.models

import org.hibernate.annotations.GenericGenerator
import javax.persistence.*

@Entity
data class Book (
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    val id: String?,
    val title: String,
    val pages: Int,
    @OneToOne
    var author: Author
)