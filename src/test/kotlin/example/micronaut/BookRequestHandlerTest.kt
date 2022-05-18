package example.micronaut
import io.micronaut.context.ApplicationContext
import io.micronaut.function.aws.test.annotation.MicronautLambdaTest
import jakarta.inject.Inject
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions

@MicronautLambdaTest
class BookRequestHandlerTest {

    @Inject
    lateinit var context: ApplicationContext

    @Test
    fun testHandler() {
        val bookRequestHandler = BookRequestHandler(context)

        val book = Book()
        val bookSaved = bookRequestHandler.execute(book)
        assert(bookSaved!!.name == "Imagine the book you wanna read")

        bookRequestHandler.applicationContext.close()
    }
}