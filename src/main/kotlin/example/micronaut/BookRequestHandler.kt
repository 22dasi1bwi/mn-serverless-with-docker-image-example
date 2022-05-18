package example.micronaut
import io.micronaut.core.annotation.Introspected
import io.micronaut.function.aws.MicronautRequestHandler
import jakarta.inject.Inject
import jakarta.inject.Singleton
import java.util.UUID

@Introspected
class BookRequestHandler : MicronautRequestHandler<Book?, BookSaved?>() {

    @Inject
    lateinit var simpleBean: SimpleBean

    override fun execute(input: Book?): BookSaved? {
        val name = simpleBean.getBookName()
        return if (input != null) {
            val bookSaved = BookSaved()
            bookSaved.name = name
            bookSaved.isbn = UUID.randomUUID().toString()
            return bookSaved
        } else {
            null
        }
    }
}

@Singleton
class SimpleBean {

    fun getBookName() = "Imagine the book you wanna read"
}